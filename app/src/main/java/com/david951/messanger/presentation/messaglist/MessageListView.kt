package com.david951.messanger.presentation.messaglist

import com.david951.messanger.presentation.Message

interface MessageListView {

    fun showMessages(messages: List<Message>)
}