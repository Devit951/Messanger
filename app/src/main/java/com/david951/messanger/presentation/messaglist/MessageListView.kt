package com.david951.messanger.presentation.messaglist

import com.david951.messanger.model.Message

interface MessageListView {

    fun showMessages(messages: List<Message>)
    fun showUndoAction(removedMessage: Message , removedPosition: Int)
}