package kr.mooner510.jcgbackend.domain.question.controller

import kr.mooner510.jcgbackend.domain.question.data.dto.response.Lesson
import kr.mooner510.jcgbackend.domain.question.data.dto.response.Questions
import kr.mooner510.jcgbackend.domain.question.service.QuestionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class QuestionController(
    private val questionService: QuestionService,
) {
    @GetMapping("/question/{id}")
    fun getQuestion(@PathVariable id: Int): Questions {
        return questionService.getQuestion(id)
    }

    @GetMapping("/lesson/{id}")
    fun getLesson(@PathVariable id: Int): Lesson {
        return questionService.getLesson(id)
    }
}