package com.pro.team.repository

import com.pro.team.domain.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by Minky on 2022-02-07
 */

@Repository
interface TeamRepository: JpaRepository<Team, Long> {
}