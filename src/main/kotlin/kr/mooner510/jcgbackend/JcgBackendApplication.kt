package kr.mooner510.jcgbackend

import kr.mooner510.jcgbackend.domain.question.data.json.QuestionData
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JcgBackendApplication

fun main(args: Array<String>) {
    QuestionData
    runApplication<JcgBackendApplication>(*args)
}
