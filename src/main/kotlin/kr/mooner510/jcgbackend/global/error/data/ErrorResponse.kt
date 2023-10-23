package kr.mooner510.jcgbackend.global.error.data

data class ErrorResponse(
    val id: Int,
    val message: String,
    val data: String
)