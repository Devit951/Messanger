package com.david951.messanger.model

import android.graphics.Color

data class Message(val id: Int , val time:Long , val text:String , val color:Int = Color.TRANSPARENT)