package com.pro.team.dto

/**
 * Created by Minky on 2022-02-07
 */
data class MemberValidateResponse(
    val result: Boolean,
    val validateType: ValidateType,
    val message: String,
) {
    companion object {
        fun of(result: Boolean): MemberValidateResponse =
                MemberValidateResponse(result, ValidateType.getType(result), ValidateType.getMessage(result))
    }
}