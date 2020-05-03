package com.tgbs.news.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tgbs.news.R
import com.tgbs.news.utils.EventObserver
import com.tgbs.news.utils.NavigationCommand

abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding> : Fragment() {

    abstract val viewModel: VM
    open val sharedViewModel: BaseViewModel? = null
    open var binding: DB? = null


    private fun init(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
    }

    abstract val layoutRes: Int

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        init(inflater, container)
        initBinding()
        bindObservables()
        return binding?.root ?: View(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configEvents()
    }


    abstract fun configEvents()


    abstract fun bindObservables()


    abstract fun initBinding()

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeNavigation()
    }

    private fun observeNavigation() {
        viewModel.navigationCommand.observe(viewLifecycleOwner, EventObserver { command ->
            navigate(command)
        })
        sharedViewModel?.navigationCommand?.observe(viewLifecycleOwner, EventObserver { command ->
            navigate(command)
        })
    }

    private fun navigate(command: NavigationCommand) {
        when (command) {
            is NavigationCommand.To ->
                findNavController().navigate(command.directions)
            is NavigationCommand.ToWithFinish -> {
                findNavController().navigate(command.directions)
                activity?.finish()
            }
            is NavigationCommand.ToRoot -> {
                findNavController().popBackStack(R.id.home, false)
            }
        }
    }
}

