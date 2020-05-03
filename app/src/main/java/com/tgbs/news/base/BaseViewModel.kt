package com.tgbs.news.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.tgbs.news.utils.Event
import com.tgbs.news.utils.NavigationCommand

abstract class BaseViewModel : ViewModel() {

    val navigationCommand = MutableLiveData<Event<NavigationCommand>>()

    fun navigateTo(directions: NavDirections) {
        navigationCommand.postValue(Event(NavigationCommand.To(directions)))
    }

    fun navigateToWithFinish(directions: NavDirections) {
        navigationCommand.postValue(Event(NavigationCommand.ToWithFinish(directions)))
    }

    fun navigateBack() {
        navigationCommand.postValue(Event(NavigationCommand.Back))
    }

}