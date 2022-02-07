package com.pro.team.dto

/**
 * Created by Minky on 2022-02-07
 */
enum class ValidateType(val message: String) {
    IN_MEMBER("Authorized Team Member"),
    OUT_OF_MEMBER("UnAuthorized Team Member");

    companion object {
        fun getType(result: Boolean): ValidateType {
            if (result) {
                return IN_MEMBER
            }
            return OUT_OF_MEMBER
        }

        fun getMessage(result: Boolean): String {
            if (result) {
                return IN_MEMBER.message
            }
            return OUT_OF_MEMBER.message
        }
    }
}