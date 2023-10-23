package kr.mooner510.jcgbackend.domain.question.data.dto.response

data class Question(
    val id: Long,
    val word: String,
    val meaning: List<String>,
)
