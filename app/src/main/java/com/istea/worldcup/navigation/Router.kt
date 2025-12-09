package com.istea.worldcup.navigation

interface Router {
    fun openGroupDetail(groupId: String)
    fun back()
}