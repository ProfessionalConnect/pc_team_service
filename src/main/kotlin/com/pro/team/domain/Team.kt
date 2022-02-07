package com.pro.team.domain

import org.bouncycastle.asn1.x500.style.RFC4519Style.description
import java.util.*
import javax.persistence.*

/**
 * Created by Minky on 2022-02-07
 */

@Entity
@Table(
    name = "team_tbl",
    uniqueConstraints = [UniqueConstraint(columnNames = ["team_id", "teamToken"])]
)
class Team(
    uuid: String,
    teamName: String,
    description: String,
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
    var description = description

    @Column(nullable = false, unique = true)
    var teamToken = UUID.randomUUID().toString()

    @OneToMany(mappedBy = "team", cascade = [(CascadeType.PERSIST)], orphanRemoval = true)
    var teamMemberList = mutableListOf<TeamMember>()
}