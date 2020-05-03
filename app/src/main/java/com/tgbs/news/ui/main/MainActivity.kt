package com.tgbs.news.ui.main

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.tgbs.news.R
import com.tgbs.news.base.BaseActivity
import com.tgbs.news.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val viewModel: MainViewModel by viewModel()

    override val layoutRes: Int = R.layout.activity_main

    override val navigationId: Int = R.id.main_navigation

    override fun configEvents() {
        setUpNavigation()
    }

    override fun bindObservables() {
    }

    override fun initBinding() {
        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = viewModel
            executePendingBindings()
        }
    }

    private fun setUpNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navigation_fragment) as NavHostFragment?
        NavigationUI.setupWithNavController(
            bottom_navigation,
            navHostFragment!!.navController
        )
    }
}
