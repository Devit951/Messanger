package com.david951.messanger.presentation.abstractadapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

abstract class AbstractRecyclerViewRowAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val rowSelector = RecyclerViewRowSelector()
    private val listOfItems = mutableListOf<Any>()

    override fun getItemViewType(position: Int): Int = rowSelector.getRow(listOfItems[position]).type()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = rowSelector.getRow(viewType).holder(parent)

    override fun getItemCount(): Int = listOfItems.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = listOfItems[position]
        rowSelector.getRow(item).bind(holder , item)
    }

    fun addAll(items: List<Any>){
        listOfItems.addAll(items)
        notifyDataSetChanged()
    }

    fun remove(position: Int){
        listOfItems.removeAt(position)
        notifyItemRemoved(position)
    }

    fun <T: Any> restore(removedPosition: Int , removedElement: T) {
        listOfItems.add(removedPosition , removedElement)
        notifyItemInserted(removedPosition)
    }
}