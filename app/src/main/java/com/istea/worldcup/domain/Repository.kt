package com.istea.worldcup.domain
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getGroups(): List<Group>
    suspend fun getGroup(id: String): Group?
}