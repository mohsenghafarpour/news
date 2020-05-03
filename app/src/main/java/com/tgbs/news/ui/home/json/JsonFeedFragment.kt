package com.tgbs.news.ui.home.json

import com.tgbs.news.R
import com.tgbs.news.base.BaseFragment
import com.tgbs.news.databinding.FragmentJsonFeedBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class JsonFeedFragment : BaseFragment<JsonFeedViewModel, FragmentJsonFeedBinding>() {

    override val viewModel: JsonFeedViewModel by viewModel()

    override val layoutRes: Int = R.layout.fragment_json_feed

    override fun configEvents() {
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