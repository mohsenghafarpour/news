package com.tgbs.news.ui.favorite

import com.tgbs.news.R
import com.tgbs.news.base.BaseFragment
import com.tgbs.news.databinding.FragmentFavoriteBinding
import com.tgbs.news.ui.NewsXmlAdapter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FavoriteViewModel, FragmentFavoriteBinding>() {

    override val viewModel: FavoriteViewModel by viewModel()
    private val adapter: NewsXmlAdapter by inject()
    override val layoutRes: Int = R.layout.fragment_favorite

    override fun configEvents() {
//        list_news.adapter = adapter
//        adapter.onItemClicked = { item , _ ->
//            viewModel.goToDetailNews(item)
//        }
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