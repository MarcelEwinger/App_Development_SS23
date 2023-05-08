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
     * Die Klasse MessageViewHolder definiert die Ansichten für jedes Element im RecyclerView
     */
    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderName: TextView = itemView.findViewById(R.id.sender_name)
        val dateInfo: TextView = itemView.findViewById(R.id.date_info)
        val messageText: TextView = itemView.findViewById(R.id.message_text)
    }

    /**
     * ViewHolder-Objekt erstellt werden muss, um eine Ansicht für ein Element in der RecyclerView anzuzeigen.
     *parent -->enthält die übergeordnete Ansicht der RecyclerView
     * viewType-Parameter, der den Typ der Ansicht des zu erstellenden ViewHolder-Objekts angibt.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        //Zunächst wird mit if-Bedingung geprüft, ob der viewType-Parameter gleich MESSAGE_TYPE_INCOMING
        val layoutId = if (viewType == MESSAGE_TYPE_INCOMING) R.layout.incoming_message_layout else R.layout.outgoing_message_layout
        //Klasse wird aufgeblasen um die View zu erstelle
        val itemView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return MessageViewHolder(itemView)
        //Schließlich wird ein neues MessageViewHolder-Objekt erstellt, und die erstellte View wird als Parameter übergeben.
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

    /**
     * gibt den Typ des anzuzeigenden Views zurück, der auf der Position in der R.View basiert
     *Position --> gibt an, für welches Element der View Typ zurückgegeben werden soll
     */
    override fun getItemViewType(position: Int): Int {
        val message = messageList[position]
        return if (message.messageType == MESSAGE_TYPE_INCOMING) {
            MESSAGE_TYPE_INCOMING
        } else {
            MESSAGE_TYPE_OUTGOING
        }
    }

    /**
     * gibt die Anzahl der Elemente zurück, die in der RecyclerView angezeigt werden
     */
    override fun getItemCount(): Int {
        return messageList.size
    }

    companion object {
        const val MESSAGE_TYPE_INCOMING = 1
        const val MESSAGE_TYPE_OUTGOING = 0
    }
}