package com.david951.messanger.presentation.common

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(imageName: String , imageView: ImageView)
}