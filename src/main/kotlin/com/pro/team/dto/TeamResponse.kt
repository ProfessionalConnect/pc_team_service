package com.pro.team.dto

import com.pro.team.domain.Team

/**
 * Created by Minky on 2022-02-07
 */
data class TeamResponse(
    val id: Long?,
    val teamName: String,
    val description: String,
) {
    companion object {
        fun of(team: Team) =
            TeamResponse(team.id, team.teamName, team.description)

        fun listOf(teamList: List<Team>) =
            teamList.map(TeamResponse::of)
    }
}