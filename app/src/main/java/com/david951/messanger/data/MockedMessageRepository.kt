package com.david951.messanger.data

import android.graphics.Color
import com.david951.messanger.model.Message
import com.david951.messanger.presentation.MessageRepository

class MockedMessageRepository : MessageRepository {

    private val onFirstPageMessages = setOf(
            Message(12, 1502110706000, "Some message", Color.GREEN),
            Message(16, 1430657906000, "Another some message", Color.RED),
            Message(18, 1373374706000, "avengers.jpg"),
            Message(19, 978440306000, "Another some message 4", Color.BLACK),
            Message(58, 1094648306000, "Another some message third" , Color.YELLOW),
            Message(94, 1162645106000, "Another some message 6", Color.BLUE),
            Message(85, 1320411506000, "dark_knight.jpg"))

    private val onSecondPageMessages = setOf(
            Message(190, 1094648306000, "Another some message 7", Color.MAGENTA),
            Message(20, 1430657906000, "Another some message 8", Color.CYAN),
            Message(21, 1320411506000, "terminator.jpg"),
            Message(22, 1502110706000, "Another some message 9", Color.LTGRAY),
            Message(23, 1373374706000, "predator.jpg"))

    private val pages = mapOf(1 to onFirstPageMessages , 2 to onSecondPageMessages)

    override fun getAllMessages(page: Int): MutableList<Message> {
        return pages[page]!!.toMutableList()
    }

    override fun pagesCount() : Int = pages.size
}