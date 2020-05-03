package com.tgbs.news.ui.home.xml

import com.tgbs.news.R
import com.tgbs.news.base.BaseFragment
import com.tgbs.news.databinding.FragmentXmlFeedBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class XmlFeedFragment : BaseFragment<XmlFeedViewModel, FragmentXmlFeedBinding>() {

    override val viewModel: XmlFeedViewModel by viewModel()

    override val layoutRes: Int = R.layout.fragment_xml_feed

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