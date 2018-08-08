package com.david951.messanger.presentation

import com.david951.messanger.data.MockedMessageRepository
import com.david951.messanger.model.Message
import com.david951.messanger.presentation.MessageRepository
import com.david951.messanger.presentation.messaglist.MessageListPresenter
import com.david951.messanger.presentation.messaglist.MessageListView
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class MessageListPresenterTest {

    @Mock private lateinit var view: MessageListView
    private var testPage = 1
    private lateinit var presenterTest: MessageListPresenter
    private val repository = MockedMessageRepository()

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        presenterTest = MessageListPresenter(repository)
    }

    @Test
    fun shouldShowAllMessagesWhenInit(){
        presenterTest.init(view)

        verify(view , times(1)).showMessages(repository.getAllMessages(testPage))
    }

    @Test
    fun shouldPageIncrementWhenLoadMoreItems(){
        presenterTest.init(view)
        presenterTest.loadMoreItems()

        assert(presenterTest.page == 2)
    }

    @Test
    fun shouldShowUndoActionWhenUserSwiped(){
        val testPosition = 2
        val testMessage = Message(18, 1373374706000, "avengers.jpg")
        presenterTest.init(view)
        presenterTest.onMessageSwiped(testPosition)

        verify(view , times(1))
                .showUndoAction(testMessage , testPosition)
    }
}