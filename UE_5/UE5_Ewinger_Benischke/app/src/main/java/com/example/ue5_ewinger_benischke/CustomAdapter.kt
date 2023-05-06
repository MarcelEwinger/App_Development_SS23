package com.example.ue5_ewinger_benischke

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val layoutId = if (viewType == MESSAGE_TYPE_INCOMING) R.layout.incoming_message_layout else R.layout.outgoing_message_layout
        val itemView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return MessageViewHolder(itemView)
    }

    /**
     * Die onBindViewHolder Methode wird vom RecyclerView aufgerufen, um die Daten für ein bestimmtes
     * Element an der gegebenen position an den ViewHolder zu binden, der durch das holder-Objekt repräsentiert wird.
     */
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentItem = messageList[position]
        holder.senderName.text = currentItem.senderName
        holder.dateInfo.text = currentItem.dateInfo
        holder.messageText.text = currentItem.messageText
    }

    override fun getItemViewType(position: Int): Int {
        val message = messageList[position]
        return if (message.messageType == MESSAGE_TYPE_INCOMING) {
            MESSAGE_TYPE_INCOMING
        } else {
            MESSAGE_TYPE_OUTGOING
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    companion object {
        const val MESSAGE_TYPE_INCOMING = 1
        const val MESSAGE_TYPE_OUTGOING = 0
    }
}