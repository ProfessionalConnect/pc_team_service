package com.pro.team.controller

import com.pro.team.dto.*
import com.pro.team.service.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

/**
 * Created by Minky on 2022-02-07
 */

@RestController
@RequestMapping("/api/v1/teams")
class TeamController {
    @Autowired
    private lateinit var teamService: TeamService

    @GetMapping("/members")
    fun getTeams(
        @RequestHeader(value = "uuid") uuid: String
    ): ResponseEntity<List<TeamResponse>> = ResponseEntity.ok(teamService.getTeams(uuid))

    @GetMapping("/members/{teamId}")
    fun getTeamMembers(
        @RequestHeader(value = "uuid") uuid: String,
        @PathVariable teamId: Long
    ): ResponseEntity<List<TeamMemberResponse>> =
        ResponseEntity.ok(teamService.getTeamMembers(uuid, teamId))

    @GetMapping("/members/{teamId}/match")
    fun validateUserTargetTeamMember(
        @RequestHeader(value = "uuid") uuid: String,
        @PathVariable teamId: Long
    ): ResponseEntity<MemberValidateResponse> =
        ResponseEntity.ok(teamService.validateUserTargetTeamMember(uuid, teamId))

    @PostMapping("/students/join")
    fun joinTeamStudent(
        @RequestHeader(value = "uuid") uuid: String,
        @RequestHeader(value = "teamToken") teamToken: String
    ): ResponseEntity<TeamResponse> {
        val teamResponse = teamService.joinTeamStudent(uuid, teamToken)
        return ResponseEntity.created(URI("/api/v1/teams/${teamResponse.id}")).body(teamResponse)
    }

    @PostMapping("/pros")
    fun setTeam(
        @RequestHeader(value = "uuid") uuid: String,
        @RequestBody teamRequest: TeamRequest
    ): ResponseEntity<Void> {
        val teamId = teamService.setTeam(uuid, teamRequest)
        return ResponseEntity.created(URI("/api/v1/teams/${teamId}")).build()
    }

    @PostMapping("/pros/join")
    fun joinTeamPro(
        @RequestHeader(value = "uuid") uuid: String,
        @RequestHeader(value = "teamToken") teamToken: String
    ): ResponseEntity<TeamResponse> {
        val teamResponse = teamService.joinTeamPro(uuid, teamToken)
        return ResponseEntity.created(URI("/api/v1/teams/${teamResponse.id}")).body(teamResponse)
    }

    @GetMapping("/pros/{teamId}/token")
    fun getTeamToken(
        @RequestHeader(value = "uuid") uuid: String,
        @PathVariable teamId: Long
    ): ResponseEntity<TeamTokenResponse> =
        ResponseEntity.ok(teamService.getTeamToken(uuid, teamId))
}