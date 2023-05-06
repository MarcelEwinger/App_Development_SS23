package com.example.ue5_ewinger_benischke

import android.annotation.SuppressLint
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// CustomAdapter that creates the ViewHolder and binds the appropriate instance to the single view
class CustomAdapter(private val messageList: List<Message>) :
    RecyclerView.Adapter<CustomAdapter.MessageViewHolder>() {

    /**
     * The MessageViewHolder class defines the views for each item in the RecyclerView
     */
    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderName: TextView = itemView.findViewById(R.id.sender_name)
        val dateInfo: TextView = itemView.findViewById(R.id.date_info)
        val messageText: TextView = itemView.findViewById(R.id.message_text)
    }

    /**
     * In the onBindViewHolder method, i bind the data from the Message object to the views in the MessageViewHolder
     */
    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val itemView = when (viewType) {
            Message.MESSAGE_TYPE_INCOMING -> LayoutInflater.from(parent.context)
                .inflate(R.layout.incoming_message_layout, parent, false)


            Message.MESSAGE_TYPE_OUTGOING -> LayoutInflater.from(parent.context)
                .inflate(R.layout.outgoing_message_layout, parent, false)
            else -> throw IllegalArgumentException("Invalid view type")
        }
        return MessageViewHolder(itemView)
    }

    /**
     * Die onBindViewHolder Methode wird vom RecyclerView aufgerufen, um die Daten für ein bestimmtes
     * Element an der gegebenen position an den ViewHolder zu binden, der durch das holder-Objekt repräsentiert wird.
     */
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentItem = messageList[position]
        holder.senderName.text = currentItem.sender
        holder.dateInfo.text = currentItem.dateInfo
        holder.messageText.text = currentItem.messageText
    }

    override fun getItemViewType(position: Int): Int {
        // Determine the view type based on IN or OUT
        return messageList[position].messageType

    }

    override fun getItemCount(): Int {
        return messageList.size
    }
}