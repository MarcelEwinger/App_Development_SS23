```
Benischke 12007588
Ewinger 12003351
```
```
UE App Development 623.9[51|52] SS 2023
Institute of Information Technology (ITEC) Primus|Münzer
```
## ASSIGNMENT 09

```
Due date: 2023/06/13|
```
```
Aim:Sensors.
```
# 1 Spirit Level

A Spirit Level (Wasserwaage) uses tubes with a liquid and a bubble to measure if an
object aligns horizontally or vertically.

```
□ Develop an application that uses the accelerometer sensor to calculate the level
of objects.
```
```
□ Visualize the level numerically.
```
```
□ Visualize the level simulating an actual bubble level.
```
# 2 GPS Sensor I

A unique selling point of mobile applications is the combination of computational
power, internet capabilities, and location awareness. Usehttps: // developers.
google. com/ maps/ documentation/ android-sdk as starting point.

```
□ Build a layout that consists of
```
```
□ two buttons: one to start tracking and one to end tracking
□ a textview that shows the current latitude and the longitude
□ a textview to show the tracked distance
□ a fragment (SupportMapFragment, used in the next task)
```
```
□ when tracking is started, periodically fetch the location data and show lati-
tude/longitude as well as the total distance in the textviews
```
# 3 GPS Sensor II

```
□ Get a Google Map API key fromhttps://console.cloud.google.comThe-
oretically, each API call will be charged. Currently, each API owner gets
approximately 28.000 API calls for free per month.
```
```
□ include Google Map View into your application
```
```
□ draw the track into the map
```



# 4 Broadcast Receivers

```
□ Study the documentation onhttps://developer.android.com/guide/components/
broadcaststo better understand the concept of broadcast receivers.
```
```
□ Implement a simple application that uses a broadcast receiver to observe and
log the battery level of the device.
```
```
□ Create a custom BroadcastReceiver class that obtains the current battery
level from the Intent object and logs it.
□ Register your receiver dynamically from the main activity. It should listen
to broadcasts regarding battery changes.
□ Ensure that the receiver only listens to these broadcasts while the activity
is visible.
```
```
□ Use the extended controls of the emulator to test your app
```
```
□ Explain the difference between manifest declaration and context registration.
```
```
□ Could we also register this receiver in the Manifest? Why (not)?
```



