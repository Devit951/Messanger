package com.david951.messanger.data

import android.graphics.Color
import com.david951.messanger.presentation.Message
import com.david951.messanger.presentation.MessageRepository

class MockedMessageRepository : MessageRepository {

    private val onFirstPageMockedMessages = listOf(
            Message(12 , 12523634 , "Some message" , Color.GREEN) ,
            Message(16 , 6483392 , "Another some message" , Color.RED) ,
            Message(18 , 7347346 , "Another some message third" , Color.YELLOW) ,
            Message(19 , 547446 , "Another some message 4" , Color.BLACK) ,
            Message(58 , 936632 , "someImage1.jpg") ,
            Message(94 , 89966 , "Another some message 6" , Color.BLUE) ,
            Message(85 , 33222 , "someImage2.jpg"))

    private val onSecondPageMockedMessages = listOf(
            Message(19 , 723526 , "Another some message 7" , Color.MAGENTA) ,
            Message(20 , 832111 , "Another some message 8" , Color.CYAN) ,
            Message(21 , 995544 , "someImage3.jpg") ,
            Message(22 , 467886 , "Another some message 9" , Color.LTGRAY) ,
            Message(23 , 234456 , "someImage4.jpg"))

    private val pages = mapOf(1 to onFirstPageMockedMessages , 2 to onSecondPageMockedMessages)

    override fun getAllMessages(page: Int): List<Message> {
        return pages[page]!!
    }
}