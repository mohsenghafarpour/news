package com.tgbs.news.ui.home

import com.tgbs.news.R
import com.tgbs.news.base.BaseFragment
import com.tgbs.news.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModel()

    override val layoutRes: Int = R.layout.fragment_home

    override fun configEvents() {
        val fragmentAdapter = HomePagerAdapter(childFragmentManager)
        view_pager.adapter = fragmentAdapter
        tabs_feed.setupWithViewPager(view_pager)
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