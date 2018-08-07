package com.david951.messanger.presentation.messaglist

import com.david951.messanger.presentation.MessageRepository

class MessangeListPresenter(private val messageRepository: MessageRepository) {

    var view : MessageListView? = null
    var page = 1

    fun init(view: MessageListView){
        this.view = view
        this.view!!.showMessages(messageRepository.getAllMessages(page))
    }
}