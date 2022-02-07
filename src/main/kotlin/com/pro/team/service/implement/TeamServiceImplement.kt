package com.pro.team.service.implement

import com.pro.team.domain.MemberType
import com.pro.team.domain.TeamMember
import com.pro.team.dto.*
import com.pro.team.repository.TeamMemberRepository
import com.pro.team.repository.TeamRepository
import com.pro.team.service.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by Minky on 2022-02-07
 */

@Service
class TeamServiceImplement: TeamService {
    @Autowired
    private lateinit var teamRepository: TeamRepository
    @Autowired
    private lateinit var teamMemberRepository: TeamMemberRepository

    @Transactional
    override fun setTeam(uuid: String, teamRequest: TeamRequest): Long? {
        val team = teamRepository.save(teamRequest.toEntity(uuid))
        teamMemberRepository.save(TeamMember(uuid, MemberType.CREATE_PRO, team))
        return team.id
    }

    @Transactional(readOnly = true)
    override fun getTeamToken(uuid: String, teamId: Long): TeamTokenResponse {
        /** TODO(Exception 처리) **/
        val team = teamRepository.findByIdAndUuid(teamId, uuid).get()
        return TeamTokenResponse(team.teamToken)
    }

    @Transactional
    override fun joinTeamStudent(uuid: String, teamToken: String): TeamResponse {
        /** TODO(Exception 처리) **/
        val team = teamRepository.findByTeamToken(teamToken).get()
        teamMemberRepository.save(TeamMember(uuid, MemberType.STUDENT, team))
        return TeamResponse.of(team)
    }

    @Transactional
    override fun joinTeamPro(uuid: String, teamToken: String): TeamResponse {
        /** TODO(Exception 처리) **/
        val team = teamRepository.findByTeamToken(teamToken).get()
        teamMemberRepository.save(TeamMember(uuid, MemberType.JOIN_PRO, team))
        return TeamResponse.of(team)
    }

    @Transactional(readOnly = true)
    override fun getTeamMembers(uuid: String, teamId: Long): List<TeamMemberResponse> {
        /** TODO(멤버 팀인증 절차 추가) **/
        /** TODO(Exception 처리) **/
        val team = teamRepository.findById(teamId).get()
        return TeamMemberResponse.listOf(teamMemberRepository.findByTeam(team))
    }

    @Transactional(readOnly = true)
    override fun validateUserTargetTeamMember(uuid: String, teamId: Long): MemberValidateResponse {
        /** TODO(Exception 처리) **/
        val team = teamRepository.findById(teamId).get()
        return MemberValidateResponse.of(teamMemberRepository.findByTeamAndUuid(team, uuid).isPresent)
    }
}