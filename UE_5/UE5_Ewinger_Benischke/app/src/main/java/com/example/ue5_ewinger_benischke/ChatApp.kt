package com.example.ue5_ewinger_benischke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ue5_ewinger_benischke.CustomAdapter.Companion.MESSAGE_TYPE_INCOMING
import com.example.ue5_ewinger_benischke.CustomAdapter.Companion.MESSAGE_TYPE_OUTGOING

class ChatApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_app)

        // Generate a static list of messages
        val messages = listOf(
            Message("Alice", "1:23 PM", "Hey, how's it going?",MESSAGE_TYPE_OUTGOING ),
            Message("Bob", "1:25 PM", "Not bad, thanks! How about you?", MESSAGE_TYPE_INCOMING ),
            Message("Alice", "1:27 PM", "Doing well, thanks for asking.", MESSAGE_TYPE_OUTGOING),
            Message("Bob", "1:30 PM", "Great to hear!", MESSAGE_TYPE_INCOMING),
            Message("Alice", "1:32 PM", "Have a good day!",MESSAGE_TYPE_OUTGOING),
            Message("Bob", "2:00 PM", "What are you up to today?", MESSAGE_TYPE_INCOMING),
            Message("Alice", "2:03 PM", "Not much, just some errands. How about you?",MESSAGE_TYPE_OUTGOING),
            Message("Bob", "2:06 PM", "I have a meeting in the afternoon, but other than that, nothing much.", MESSAGE_TYPE_INCOMING),
            Message("Alice", "2:10 PM", "Sounds busy. Good luck with the meeting!", MESSAGE_TYPE_OUTGOING),
            Message("Bob", "2:13 PM", "Thanks! Hopefully it goes well.", MESSAGE_TYPE_INCOMING),
            Message("Alice", "2:15 PM", "I'm sure it will. You always do a great job.", MESSAGE_TYPE_OUTGOING),
            Message("Bob", "2:18 PM", "Thanks for the vote of confidence!", MESSAGE_TYPE_INCOMING),
            Message("Alice", "2:20 PM", "No problem. Let me know how it goes!", MESSAGE_TYPE_OUTGOING),
            Message("Bob", "2:23 PM", "Will do!", MESSAGE_TYPE_INCOMING),
            Message("Alice", "2:25 PM", "Take care!", MESSAGE_TYPE_OUTGOING)
        )

        val recyclerView: RecyclerView = findViewById(R.id.my_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(messages)
    }
}