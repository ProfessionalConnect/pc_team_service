package com.pro.team.dto

import com.pro.team.domain.TeamMember

/**
 * Created by Minky on 2022-02-07
 */
data class TeamMemberResponse(
    val uuid: String,
    val memberType: String,
) {
    companion object {
        fun of(teamMember: TeamMember) =
            TeamMemberResponse(teamMember.uuid, teamMember.memberType.name)

        fun listOf(teamMemberList: List<TeamMember>) =
            teamMemberList.map(TeamMemberResponse::of)
    }
}