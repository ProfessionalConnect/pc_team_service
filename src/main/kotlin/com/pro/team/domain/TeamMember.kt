package com.pro.team.domain

import javax.persistence.*

/**
 * Created by Minky on 2022-02-07
 */

@Entity
@Table(name = "team_member_tbl")
class TeamMember(
    uuid: String,
    memberType: MemberType,
    team: Team,
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_member_sequence_gen")
    @SequenceGenerator(name = "team_member_sequence_gen", sequenceName = "team_member_sequence")
    @Column(name = "team_member_id", nullable = false)
    var id: Long? = null

    @Column(nullable = false)
    var uuid = uuid

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var memberType = memberType

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    var team = team
}