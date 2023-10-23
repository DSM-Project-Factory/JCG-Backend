package kr.mooner510.jcgbackend.global.error.types

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val message: String,
    val status: HttpStatus
) {
    QUESTION_NOT_FOUND("등록되지 않은 문제입니다.", HttpStatus.NOT_FOUND),
    LESSON_NOT_FOUND("등록되지 않은 단원입니다.", HttpStatus.NOT_FOUND),
    DATA_NOT_FOUND("정보를 가져오는 도중 문제가 발생했습니다.", HttpStatus.NOT_FOUND),

    EXPIRED_TOKEN("로그인이 만료되었습니다.", HttpStatus.FORBIDDEN),
    INVALID_TOKEN("Invalid Token", HttpStatus.FORBIDDEN),
    TOKEN_IS_NULL("Token Can Not Be Null", HttpStatus.FORBIDDEN),
}