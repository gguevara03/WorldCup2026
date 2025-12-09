package com.istea.worldcup.domain

import android.content.Context
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json

class RepositoryImpl(
    private val context: Context
) : Repository {

    private val json = Json { ignoreUnknownKeys = true }

    // Cache en memoria
    private val groupsState = MutableStateFlow<List<Group>>(emptyList())

    init {
        loadJson()
    }

    private fun loadJson() {
        val jsonString = context.assets.open("fixture.json")
            .bufferedReader()
            .use { it.readText() }

        val parsed = json.decodeFromString<List<Group>>(jsonString)
        groupsState.value = parsed
    }

    override suspend fun getGroups(): List<Group> {
        delay(2000)
        return groupsState.value
    }

    override suspend fun getGroup(id: String): Group? {
        delay(2000)
        return groupsState.value.find { it.id == id }
    }
}
