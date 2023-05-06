package com.example.ue5_ewinger_benischke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_app)

        // Generate a static list of messages
        val messages = listOf(
            Message("Alice", "1:23 PM", "Hey, how's it going?", Message.MESSAGE_TYPE_OUTGOING),
            Message("Bob", "1:25 PM", "Not bad, thanks! How about you?", Message.MESSAGE_TYPE_INCOMING),
            Message("Alice", "1:27 PM", "Doing well, thanks for asking.", Message.MESSAGE_TYPE_OUTGOING),
            Message("Bob", "1:30 PM", "Great to hear!", Message.MESSAGE_TYPE_INCOMING),
            Message("Alice", "1:32 PM", "Have a good day!", Message.MESSAGE_TYPE_OUTGOING),
            Message("Bob", "2:00 PM", "What are you up to today?", Message.MESSAGE_TYPE_OUTGOING),
            Message("Alice", "2:03 PM", "Not much, just some errands. How about you?", Message.MESSAGE_TYPE_INCOMING),
            Message("Bob", "2:06 PM", "I have a meeting in the afternoon, but other than that, nothing much.", Message.MESSAGE_TYPE_OUTGOING),
            Message("Alice", "2:10 PM", "Sounds busy. Good luck with the meeting!", Message.MESSAGE_TYPE_INCOMING),
            Message("Bob", "2:13 PM", "Thanks! Hopefully it goes well.", Message.MESSAGE_TYPE_OUTGOING),
            Message("Alice", "2:15 PM", "I'm sure it will. You always do a great job.", Message.MESSAGE_TYPE_INCOMING),
            Message("Bob", "2:18 PM", "Thanks for the vote of confidence!", Message.MESSAGE_TYPE_OUTGOING),
            Message("Alice", "2:20 PM", "No problem. Let me know how it goes!", Message.MESSAGE_TYPE_INCOMING),
            Message("Bob", "2:23 PM", "Will do!", Message.MESSAGE_TYPE_OUTGOING),
            Message("Alice", "2:25 PM", "Take care!", Message.MESSAGE_TYPE_INCOMING)
        )

        val recyclerView: RecyclerView = findViewById(R.id.my_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(messages)
    }
}