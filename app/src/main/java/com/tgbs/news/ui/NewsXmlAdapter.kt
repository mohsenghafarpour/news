package com.tgbs.news.ui

import androidx.recyclerview.widget.DiffUtil
import com.tgbs.news.R
import com.tgbs.news.base.BaseAdapter
import com.tgbs.news.data.Detail

class NewsXmlAdapter : BaseAdapter<Detail>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Detail>() {
            override fun areItemsTheSame(oldItem: Detail, newItem: Detail): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Detail, newItem: Detail): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_news_xml
    }

}