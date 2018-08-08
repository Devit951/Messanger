package com.david951.messanger.presentation.messaglist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.david951.messanger.R
import com.david951.messanger.model.Message
import com.david951.messanger.presentation.common.ImageLoader
import com.david951.messanger.presentation.abstractadapter.RecyclerViewRow
import com.david951.messanger.presentation.abstractadapter.RecyclerViewRowHolder
import kotlinx.android.synthetic.main.item_message_with_image.view.*

class MessageRowWithImage(private val imageLoader: ImageLoader) : RecyclerViewRow {

    private val imageTypes = listOf(".jpg" , ".jpeg")

    override fun `is`(item: Any): Boolean {
        if (item is Message){
            for (imageType in imageTypes){
                if (item.text.endsWith(imageType)){
                    return true
                }
            }
        }
        return false
    }

    override fun type(): Int = R.layout.item_message_with_image

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message_with_image , parent , false)
        return MessageWithImageViewHolder(view , imageLoader)
    }

    override fun bind(holder: RecyclerView.ViewHolder, item: Any) {
        val messageHolder = holder as MessageWithImageViewHolder
        val message = item as Message
        messageHolder.bind(message.text)
    }

    class MessageWithImageViewHolder(itemView: View, private val imageLoader: ImageLoader) : RecyclerViewRowHolder<String>(itemView) {
        override fun bind(imageName: String) {
            imageLoader.loadImage(imageName , itemView.iv_message)
        }
    }
}