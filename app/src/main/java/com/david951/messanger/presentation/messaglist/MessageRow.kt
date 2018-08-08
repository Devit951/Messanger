package com.david951.messanger.presentation.messaglist

import android.support.annotation.StringRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.david951.messanger.R
import com.david951.messanger.model.Message
import com.david951.messanger.presentation.abstractadapter.RecyclerViewRowHolder
import com.david951.messanger.presentation.abstractadapter.RecyclerViewRow
import kotlinx.android.synthetic.main.item_message.view.*
import java.text.SimpleDateFormat
import java.util.*

class MessageRow : RecyclerViewRow {

    override fun `is`(item: Any): Boolean {
        return item is Message && item.text.notEndsWith(".jpg")
    }

    override fun type(): Int = R.layout.item_message

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_message , parent , false)
        return MessageViewHolder(rootView)
    }

    override fun bind(holder: RecyclerView.ViewHolder, item: Any) {
        val message = item as Message
        val messageHolder = holder as MessageViewHolder
        messageHolder.bind(message)
    }

    class MessageViewHolder(itemView: View) : RecyclerViewRowHolder<Message>(itemView) {
        override fun bind(item: Message) {
            itemView.tv_message_id.text = getString(R.string.message_id, item.id.toString())
            itemView.tv_message_date.text = getString(R.string.message_date , formatTimestamp(item.time))
            itemView.tv_message_text.text = item.text
            itemView.view_message_sticky.setBackgroundColor(item.color)
        }

        private fun formatTimestamp(timestamp: Long): String{
            val simpleDateFormat = SimpleDateFormat("dd MMMM, yyyy" , Locale.getDefault())
            return simpleDateFormat.format(Date(timestamp))
        }

        private fun getString(@StringRes resId: Int , str: String) = itemView.context.getString(resId , str)
    }

    private fun String.notEndsWith(str: String) = !endsWith(str)
}