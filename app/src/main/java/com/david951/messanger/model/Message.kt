package com.david951.messanger.presentation

import android.graphics.Color

data class Message(val id: Int , val time:Long , val text:String , val color:Int = Color.TRANSPARENT)