package com.tgbs.news.ui.home.detail

import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.tgbs.news.R
import com.tgbs.news.base.BaseFragment
import com.tgbs.news.databinding.FragmentDetailNewsBinding
import kotlinx.android.synthetic.main.fragment_detail_news.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailNewsFragment : BaseFragment<DetailNewsViewModel, FragmentDetailNewsBinding>() {

    override val viewModel: DetailNewsViewModel by viewModel()
    private val args: DetailNewsFragmentArgs by navArgs()

    private var url: String? = null

    override val layoutRes: Int = R.layout.fragment_detail_news

    override fun configEvents() {
        my_web_view.webViewClient = MyWebViewClient()
        viewModel.loadUrl(args.id, args.newsType)
    }

    override fun bindObservables() {
        viewModel.news.observe(this, Observer {
            if (it?.link == url) return@Observer
            url = it?.link
            my_web_view.loadUrl(url)
        })
    }

    override fun initBinding() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
            executePendingBindings()
        }
    }
}