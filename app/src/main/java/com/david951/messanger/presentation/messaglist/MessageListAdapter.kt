package com.david951.messanger.presentation.messaglist

import com.david951.messanger.presentation.abstractadapter.AbstractRecyclerViewRowAdapter
import com.david951.messanger.presentation.common.AssetImageLoader

class MessageListAdapter : AbstractRecyclerViewRowAdapter() {

    init {
        this.rowSelector.addRow(MessageRow())
        this.rowSelector.addRow(MessageRowWithImage(AssetImageLoader()))
    }
}