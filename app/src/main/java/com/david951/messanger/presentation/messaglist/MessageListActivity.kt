package com.david951.messanger.presentation.messaglist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import com.david951.messanger.R
import com.david951.messanger.data.MockedMessageRepository
import com.david951.messanger.model.Message
import com.david951.messanger.presentation.common.PaginationScrollListener
import kotlinx.android.synthetic.main.activity_message_list.*
import android.support.v7.widget.helper.ItemTouchHelper
import com.david951.messanger.presentation.common.RecyclerItemTouchHelper

class MessageListActivity : AppCompatActivity() , MessageListView, RecyclerItemTouchHelper.Callback {

    private lateinit var adapter: MessageListAdapter
    private var presenter: MessageListPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_list)
        initAdapter()
        initPresenter()
    }

    override fun showMessages(messages: List<Message>) {
        adapter.addAll(messages)
    }

    override fun onSwiped(adapterPosition: Int) {
        presenter?.onMessageSwiped(adapterPosition)
        adapter.remove(adapterPosition)
    }

    override fun showUndoAction(removedMessage: Message , removedPosition: Int){
        Snackbar.make(rv_messages , getString(R.string.message_you_can_undo_this_action) , Snackbar.LENGTH_LONG)
                .setAction(R.string.undo , {
                    presenter?.onUndoClicked(removedMessage , removedPosition)
                    adapter.restore(removedPosition , removedMessage)
                })
                .show()
    }

    override fun onRetainCustomNonConfigurationInstance(): Any = presenter!!

    override fun onDestroy(){
        presenter?.detachView()
        super.onDestroy()
    }

    private fun initAdapter(){
        adapter = MessageListAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        rv_messages.layoutManager = linearLayoutManager
        rv_messages.addOnScrollListener(object : PaginationScrollListener(linearLayoutManager) {
            override fun loadMoreItems() = presenter!!.loadMoreItems()
            override fun isLastPage(): Boolean = presenter!!.isLastPage()
        })
        rv_messages.adapter = adapter
        ItemTouchHelper(RecyclerItemTouchHelper(this, this)).attachToRecyclerView(rv_messages)
    }

    private fun initPresenter(){
        presenter = lastCustomNonConfigurationInstance as MessageListPresenter?
        if (presenter == null){
            presenter = MessageListPresenter(MockedMessageRepository())
        }
        presenter!!.init(this)
    }
}
