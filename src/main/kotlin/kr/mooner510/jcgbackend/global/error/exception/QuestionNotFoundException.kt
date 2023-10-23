package kr.mooner510.jcgbackend.global.error.exception

import kr.mooner510.jcgbackend.global.error.data.GlobalError
import kr.mooner510.jcgbackend.global.error.types.ErrorCode

class QuestionNotFoundException: GlobalError(ErrorCode.QUESTION_NOT_FOUND, "") {
}