package com.david951.messanger.presentation.messaglist

import com.david951.messanger.model.Message
import com.david951.messanger.presentation.MessageRepository

class MessageListPresenter(private val messageRepository: MessageRepository) {

    var page = 1
    private var view : MessageListView? = null
    private val listOfMessages = messageRepository.getAllMessages(page)

    fun init(view: MessageListView){
        this.view = view
        this.view!!.showMessages(listOfMessages)
    }

    fun loadMoreItems(){
        page++
        view!!.showMessages(messageRepository.getAllMessages(page))
        listOfMessages.addAll(messageRepository.getAllMessages(page))
    }

    fun isLastPage(): Boolean {
        return messageRepository.pagesCount() == page;
    }

    fun onMessageSwiped(adapterPosition: Int) {
        val removedMessage = listOfMessages.removeAt(adapterPosition)
        view!!.showUndoAction(removedMessage , adapterPosition)
    }

    fun onUndoClicked(removedMessage: Message, removedPosition: Int) {
        listOfMessages.add(removedPosition , removedMessage)
    }

    fun detachView() {
        view = null
    }
}