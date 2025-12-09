package com.istea.worldcup.domain

import kotlinx.serialization.Serializable

@Serializable
data class Match(
    val id: String,
    val home: String,
    val away: String,
    val date: String
)

@Serializable
public data class Group(
    val id: String,
    val name: String,
    val teams: List<String>,
    val matches: List<Match>
)