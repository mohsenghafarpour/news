package com.tgbs.news.ui.home.json

import com.tgbs.news.R
import com.tgbs.news.base.BaseFragment
import com.tgbs.news.databinding.FragmentJsonFeedBinding
import com.tgbs.news.ui.NewsEnAdapter
import kotlinx.android.synthetic.main.fragment_json_feed.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class JsonFeedFragment : BaseFragment<JsonFeedViewModel, FragmentJsonFeedBinding>() {

    override val viewModel: JsonFeedViewModel by viewModel()
    private val adapter: NewsEnAdapter by inject()

    override val layoutRes: Int = R.layout.fragment_json_feed

    override fun configEvents() {
        list_news.adapter = adapter
        adapter.onItemClicked = { item , _ ->
            viewModel.goToDetailNews(item.url)
        }
    }

    override fun bindObservables() {
    }

    override fun initBinding() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
            executePendingBindings()
        }
    }
}