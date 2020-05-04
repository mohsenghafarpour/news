package com.tgbs.news.utils.ba

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.tgbs.news.utils.ktx.load
import com.tgbs.news.utils.ktx.loadRounded
import com.tgbs.news.utils.ktx.px


@BindingAdapter("image", "placeholder", requireAll = false)
fun ImageView.imageUrl(url: String?, placeholder: Drawable?) {
    load(url, placeholder)
}


@BindingAdapter("imageRounded", "radius", "centerCrop", requireAll = false)
fun ImageView.setImageRounded(
    url: String?,
    radius: Int?,
    centerCrop: Boolean?
) {
    loadRounded(url, radius?.px ?: 0, centerCrop = centerCrop ?: false)
}