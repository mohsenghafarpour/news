package com.tgbs.news.ui.home.xml

import com.tgbs.news.R
import com.tgbs.news.base.BaseFragment
import com.tgbs.news.databinding.FragmentXmlFeedBinding
import com.tgbs.news.ui.NewsFaAdapter
import kotlinx.android.synthetic.main.fragment_xml_feed.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class XmlFeedFragment : BaseFragment<XmlFeedViewModel, FragmentXmlFeedBinding>() {

    override val viewModel: XmlFeedViewModel by viewModel()
    private val adapter: NewsFaAdapter by inject()

    override val layoutRes: Int = R.layout.fragment_xml_feed

    override fun configEvents() {
        list_news.adapter = adapter
        adapter.onItemClicked = { item, _ ->
            viewModel.goToDetailNews(item)
        }
        adapter.onFavoriteClicked = {
            viewModel.onFavoriteClicked(it)
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