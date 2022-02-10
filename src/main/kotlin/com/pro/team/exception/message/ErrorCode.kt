package com.pro.team.exception.message

import org.springframework.http.HttpStatus

/**
 * Created by Minky on 2022-02-09
 */
enum class ErrorCode(
    val code: Int,
    val message: String,
    val httpStatus: HttpStatus
) {
    NOT_FOUND_TEAM(404, "[ERROR] Team is not found", HttpStatus.NOT_FOUND), ;
}