package com.david951.messanger.presentation

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

abstract class AbstractRecyclerViewRowAdapter(private val listOfItems: List<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val rowSelector = RecyclerViewRowSelector()

    override fun getItemViewType(position: Int): Int = rowSelector.getRow(listOfItems[position]).type()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = rowSelector.getRow(viewType).holder(parent)

    override fun getItemCount(): Int = listOfItems.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = listOfItems[position]
        rowSelector.getRow(item).bind(holder , item)
    }
}