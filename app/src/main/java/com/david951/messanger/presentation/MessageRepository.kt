package com.david951.messanger.presentation

import com.david951.messanger.model.Message

interface MessageRepository {

    fun getAllMessages(page: Int) : MutableList<Message>
    fun pagesCount() : Int
}