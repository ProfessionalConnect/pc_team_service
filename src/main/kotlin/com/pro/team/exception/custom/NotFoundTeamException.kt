package com.pro.team.exception.custom

import com.pro.team.exception.message.ErrorCode

/**
 * Created by Minky on 2022-02-11
 */
class NotFoundTeamException:
        CustomException(ErrorCode.NOT_FOUND_TEAM)