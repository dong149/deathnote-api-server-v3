package com.deathnote.api.exception

import org.springframework.http.HttpStatus

open class DeathnoteException(
    status: HttpStatus,
    message: String
) : Throwable(message) {
    constructor(errorCode: ErrorCode) : this(errorCode.status, errorCode.message)
    constructor(errorCode: ErrorCode, message: String) : this(errorCode.status, message)
}

enum class ErrorCode(
    val status: HttpStatus,
    val message: String
) {
    SUMMONER_NOT_FOUND(HttpStatus.BAD_REQUEST, "존재하지 않는 소환사입니다."),
    MATCH_LIST_NOT_FOUNT(HttpStatus.BAD_REQUEST, "매치 정보가 존재하지 않습니다."),
    MATCH_INFO_EMPTY(HttpStatus.BAD_REQUEST, "매치 정보가 비어있습니다.")
}