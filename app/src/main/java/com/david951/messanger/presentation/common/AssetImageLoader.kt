package com.david951.messanger.presentation.common

import android.widget.ImageView
import com.squareup.picasso.Picasso

class AssetImageLoader : ImageLoader {

    override fun loadImage(imageName: String , imageView: ImageView) {
        Picasso.get()
                .load("file:///android_asset/$imageName")
                .fit()
                .centerCrop()
                .into(imageView)
    }
}