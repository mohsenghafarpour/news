package com.tgbs.news.ui

import androidx.recyclerview.widget.DiffUtil
import com.tgbs.news.R
import com.tgbs.news.base.BaseAdapter
import com.tgbs.news.data.pojo.Article
import kotlinx.android.synthetic.main.item_news_en.view.*

class NewsEnAdapter : BaseAdapter<Article>(DIFF_CALLBACK) {

    var onFavoriteClicked: ((article: Article) -> Unit)? = null

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_news_en
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.img_favorite_en?.setOnClickListener {
            val item = getItem(holder.adapterPosition)
            onFavoriteClicked?.invoke(item)
        }
    }

}