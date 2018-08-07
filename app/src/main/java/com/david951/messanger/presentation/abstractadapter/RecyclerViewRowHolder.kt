package com.david951.messanger.presentation.abstractadapter

import android.support.v7.widget.RecyclerView
import android.view.View



abstract class RecyclerViewRowHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}