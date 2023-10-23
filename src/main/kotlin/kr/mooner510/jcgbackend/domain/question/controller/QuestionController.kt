package kr.mooner510.jcgbackend.domain.question.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.headers.Header
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import kr.mooner510.jcgbackend.domain.question.data.dto.response.Lesson
import kr.mooner510.jcgbackend.domain.question.data.dto.response.Questions
import kr.mooner510.jcgbackend.domain.question.service.QuestionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@Tag(name = "JCG English API")
class QuestionController(
    private val questionService: QuestionService,
) {
    @Operation(
        summary = "질문 가져오기",
        description = "1학년의 2과를 가져오고 싶다면 id는 '102'. 2학년의 4과를 가져오고 싶다면 id는 '204'."
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "성공적"),
        ApiResponse(responseCode = "404", description = "Not found - id로 저장된 데이터가 없음")
    ])
    @GetMapping("/question/{id}")
    fun getQuestion(@PathVariable id: Int): Questions {
        return questionService.getQuestion(id)
    }

    @Operation(
        summary = "질문 가져오기",
        description = "1학년의 2과를 가져오고 싶다면 id는 '102'. 2학년의 4과를 가져오고 싶다면 id는 '204'."
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "성공적"),
        ApiResponse(responseCode = "404", description = "Not found - id로 저장된 데이터가 없음")
    ])
    @GetMapping("/lesson/{id}")
    fun getLesson(@PathVariable id: Int): Lesson {
        return questionService.getLesson(id)
    }
}