package kr.mooner510.jcgbackend.global.error.data

import kr.mooner510.jcgbackend.global.error.types.ErrorCode

open class GlobalError(
    val errorCode: ErrorCode,
    val data: String
): RuntimeException(errorCode.message)