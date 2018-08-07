package com.david951.messanger.presentation.messaglist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.david951.messanger.R
import com.david951.messanger.data.MockedMessageRepository
import com.david951.messanger.presentation.Message

class MessageListActivity : AppCompatActivity() , MessageListView {

    private val presenter = MessangeListPresenter(MockedMessageRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_list)
    }

    override fun showMessages(messages: List<Message>) {

    }

    private fun initPresenter(){
        presenter.init(this)
    }
}
