package com.pro.team.domain

import javax.persistence.*

/**
 * Created by Minky on 2022-02-07
 */

@Entity
@Table(name = "team_tbl")
class Team(
    uuid: String,
    teamName: String,
    password: String,
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_sequence_gen")
    @SequenceGenerator(name = "team_sequence_gen", sequenceName = "team_sequence")
    @Column(name = "team_id", nullable = false)
    var id: Long? = null

    @Column(nullable = false)
    var uuid = uuid

    @Column(nullable = false)
    var teamName = teamName

    @Column(nullable = false)
    var password = password
}