package com.example.ue5_ewinger_benischke
// Message class with sender name, date info, message text, and message type (in or out)
data class Message(
    val sender: String,
    val dateInfo: String,
    val messageText: String,
    val messageType: Int
){
    companion object {
        const val MESSAGE_TYPE_INCOMING = 1
        const val MESSAGE_TYPE_OUTGOING = 0
    }
}




