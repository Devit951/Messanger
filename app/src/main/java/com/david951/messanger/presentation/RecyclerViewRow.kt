package com.david951.messanger.presentation

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

interface RecyclerViewRow {

    fun `is`(item: Any): Boolean

    fun type(): Int

    fun holder(parent: ViewGroup): RecyclerView.ViewHolder

    fun bind(holder: RecyclerView.ViewHolder, item: Any)
}