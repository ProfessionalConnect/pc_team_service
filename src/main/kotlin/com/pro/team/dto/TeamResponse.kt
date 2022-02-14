package com.pro.team.dto

import com.pro.team.domain.Team
import java.time.LocalDateTime

/**
 * Created by Minky on 2022-02-07
 */
data class TeamResponse(
    val id: Long?,
    val teamName: String,
    val description: String,
    val createdDate: LocalDateTime,
    val lastModifiedDate: LocalDateTime,
) {
    companion object {
        fun of(team: Team) =
            TeamResponse(
                team.id,
                team.teamName,
                team.description,
                team.createdDate,
                team.lastModifiedDate
            )

        fun listOf(teamList: List<Team>) =
            teamList.map(TeamResponse::of)
    }
}