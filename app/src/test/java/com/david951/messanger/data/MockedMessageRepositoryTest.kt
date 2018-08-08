package com.david951.messanger.data

import com.david951.messanger.presentation.MessageRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MockedMessageRepositoryTest{

    private val testPage = 2
    private val mockedRepository: MessageRepository = MockedMessageRepository()

    @Test
    fun shouldPageCountEquals(){
        assert(testPage == mockedRepository.pagesCount())
    }

    @Test
    fun shouldMessageListSizeEqualsOnFirstPage(){
        val messageListSize = 7
        assert(messageListSize == mockedRepository.getAllMessages(1).size)
    }

    @Test
    fun shouldMessageListSizeEqualsOnSecondPage(){
        val messageListSize = 5
        assert(messageListSize == mockedRepository.getAllMessages(2).size)
    }
}