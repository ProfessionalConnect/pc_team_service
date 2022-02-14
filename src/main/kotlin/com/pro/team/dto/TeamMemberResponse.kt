package com.pro.team.dto

import com.pro.team.domain.TeamMember
import java.time.LocalDateTime

/**
 * Created by Minky on 2022-02-07
 */
data class TeamMemberResponse(
    val uuid: String,
    val memberType: String,
    val createdDate: LocalDateTime,
    val lastModifiedDate: LocalDateTime,
) {
    companion object {
        fun of(teamMember: TeamMember) =
            TeamMemberResponse(
                teamMember.uuid,
                teamMember.memberType.name,
                teamMember.createdDate,
                teamMember.lastModifiedDate
            )

        fun listOf(teamMemberList: List<TeamMember>) =
            teamMemberList.map(TeamMemberResponse::of)
    }
}