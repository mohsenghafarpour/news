package com.tgbs.news.utils

import androidx.navigation.NavDirections


sealed class NavigationCommand {
    data class To(val directions: NavDirections) : NavigationCommand()
    data class ToWithFinish(val directions: NavDirections) : NavigationCommand()
    object Back : NavigationCommand()
    object ToRoot : NavigationCommand()
}