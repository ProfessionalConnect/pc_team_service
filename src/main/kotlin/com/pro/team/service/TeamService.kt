package com.pro.team.service

import com.pro.team.dto.*

/**
 * Created by Minky on 2022-02-07
 */
interface TeamService {
    fun setTeam(uuid: String, teamRequest: TeamRequest): Long?
    fun getTeamToken(uuid: String, teamId: Long): TeamTokenResponse
    fun joinTeamStudent(uuid: String, teamToken: String): TeamResponse
    fun joinTeamPro(uuid: String, teamToken: String): TeamResponse
    fun getTeamMembers(uuid: String, teamId: Long): List<TeamMemberResponse>
    fun validateUserTargetTeamMember(uuid: String, teamId: Long): MemberValidateResponse
}