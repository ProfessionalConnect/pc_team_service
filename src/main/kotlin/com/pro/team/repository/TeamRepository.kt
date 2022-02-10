package com.pro.team.repository

import com.pro.team.domain.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

/**
 * Created by Minky on 2022-02-07
 */

@Repository
interface TeamRepository: JpaRepository<Team, Long> {
    fun findByUuid(uuid: String): List<Team>
    fun findByIdAndUuid(id: Long, uuid: String): Optional<Team>
    fun findByTeamToken(teamToken: String): Optional<Team>
}