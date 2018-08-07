package com.david951.messanger.presentation

interface MessageRepository {

    fun getAllMessages(page: Int) : List<Message>
}