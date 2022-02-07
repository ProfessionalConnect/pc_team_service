package com.pro.team.dto

import com.pro.team.domain.Team

/**
 * Created by Minky on 2022-02-07
 */
data class TeamRequest(
    val teamName: String,
    val description: String,
) {
    fun toEntity(uuid: String) =
        Team(uuid, teamName, description)
}