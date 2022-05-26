package com.deathnote.api.utils

import java.time.LocalDateTime

class DateUtils {

    companion object {
        fun utcNow(): LocalDateTime {
            return LocalDateTime.now()
        }
    }
}