package com.pro.team.repository

import com.pro.team.domain.Team
import com.pro.team.domain.TeamMember
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

/**
 * Created by Minky on 2022-02-07
 */

@Repository
interface TeamMemberRepository: JpaRepository<TeamMember, Long> {
    fun findByTeam(team: Team): List<TeamMember>
    fun findByTeamAndUuid(team: Team, uuid: String): Optional<TeamMember>
}