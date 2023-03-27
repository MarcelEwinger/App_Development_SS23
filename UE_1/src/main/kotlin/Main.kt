fun main() {
    var brand1 = Brand("Mercedes", "Germany", "0800 1886 00", "mbcc-aut@mercedes-benz.com")
    var workshop1 = Workshop("Meyer-Hafner GmbH", "Austria", 9020, "Klagenfurt", "St. Veiter Str. 186", "0463 203380")
    var workshop2 = Workshop("Wolfgang Denzel AG", "Austria", 9010, "Klagenfurt", "Feldkirchner Str. 90", "0463 45400")

    var workshops = ArrayList<Workshop>()
    workshops.add(workshop1)
    workshops.add(workshop2)

    var vehicle1 = Vehicle(10000, "EQS Limousine", brand1, workshops,
    2480, 2945, 200.00, 210.00 )


    vehicle1.printInfo()

    println("###############################################")
    //Test acceleration
    println("Acceleration Test")
    println("Current Speed " + vehicle1.getSpeed())
    vehicle1.accelerate()
    println("Current Speed " + vehicle1.getSpeed())
    vehicle1.accelerate()
    println("Current Speed " + vehicle1.getSpeed())

    println("###############################################")
    //Test brake
    println("Break Test")
    vehicle1.brake()
    println("Current Speed " + vehicle1.getSpeed())
    //Speed < 0
    vehicle1.setSpeed(0.00)
    println("Current Speed " + vehicle1.brake())


    println("###############################################")
    //Workshop
    println("Workshop Test")
    println("Workshop: " + vehicle1.getWorkshop(9020))
    println("Workshop: " + vehicle1.getWorkshop(90200))

    println("###############################################")
    //Drive
    vehicle1.setSpeed(50.00)
    vehicle1.drive(10);
    println("Current Speed " + vehicle1.getSpeed())


}


class Vehicle(
    id: Int, name: String, brand: Brand, workshops: ArrayList<Workshop>,
    weight: Int, maxPermissibleWeight: Int, speed: Double, maxSpeed: Double){
    private var id = id
    private var name = name
    private var brand = brand
    private var workshops = workshops
    private var weight = weight
    private var maxPermissibleWeight = maxPermissibleWeight
    private var speed = speed
    private var maxSpeed = maxSpeed

    fun getSpeed(): Double{
        return speed
    }

    fun setSpeed(speed: Double ){
        this.speed = speed
    }

    fun accelerate(): Double{
        return if ((speed + 10) <= maxSpeed) { //check if speed + 10 is less than maxSpeed
            speed +=10//return newSpeed if
            speed //return speed
        } else {//If newSpeed is greater than maxSpeed, return
            maxSpeed //return maxSpeed
        }
    }

    fun brake(): Double {
        return if ((speed -10) <= 0.00) {//if speed less than 0
            speed = 0.00 //set speed to zero
            speed //return speed
        } else{
            speed -= 10 //reduce speed by 10
            speed //return speed
        }
    }

    fun printInfo(){
          println("Vehicle(id=$id ,\n name='$name',\n brand=$brand,\n workshops=$workshops,\n weight=$weight,\n maxPermissibleWeight=$maxPermissibleWeight, \n speed=$speed,\n maxSpeed=$maxSpeed)")
    }

    fun getWorkshop(postcode: Int): Workshop?{
        for (obj in workshops){ //loop through ArrayList of Workshop
            if(obj.getPostCode() == postcode){
                return obj
            }
        }
        return null
    }

    fun drive(kilometers: Int){
        for(i in 1..kilometers){//Loop through kilometers
            println("Start: " + getSpeed())
            println("Kilometer: " + i)
            for(j in 1..3){//per Kilometers three times
                if (speed < 50) {
                    accelerate()
                    println(getSpeed())
                } else {
                    brake()
                    println(getSpeed())
                }
            }
        }

    }
}

class Brand (name: String, country: String, phone: String, email : String){
    private var name = name
    private var country = country
    private var phone = phone
    private var email = email

    override fun toString(): String {
        return "Brand(name='$name', country='$country', phone='$phone', email='$email')"
    }


}

class Workshop (name : String, country: String, postcode: Int, city : String,
                street: String, phone: String ){
    private var name = name
    private var country = country
    private var postcode = postcode
    private var city = city
    private var street = street
    private var phone = phone

    fun getPostCode(): Int{
        return postcode
    }
    override fun toString(): String {
        return "Workshop(name='$name', country='$country', postcode=$postcode, city='$city', street='$street', phone='$phone')"
    }


}