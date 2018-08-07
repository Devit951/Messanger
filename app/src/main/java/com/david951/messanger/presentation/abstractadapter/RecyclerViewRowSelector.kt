package com.david951.messanger.presentation

import kotlin.IllegalStateException

class RecyclerViewRowSelector {

    private val rowList = mutableListOf<RecyclerViewRow>()

    fun addRow(row: RecyclerViewRow) {
        rowList.add(row)
    }

    fun removeRow(row: RecyclerViewRow) {
        rowList.remove(row)
    }

    fun getRow(item: Any): RecyclerViewRow {
        for (row in rowList) {
            if (row.`is`(item)) {
                return row
            }
        }
        throw NoSuchRecyclerRowException()
    }

    fun getRow(viewType: Int): RecyclerViewRow {
        for (row in rowList) {
            if (row.type() == viewType) {
                return row
            }
        }
        throw NoSuchRecyclerRowException()
    }

    class NoSuchRecyclerRowException(override val message: String? = "No such row have been added") : IllegalStateException(message)
}