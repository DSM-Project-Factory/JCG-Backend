package kr.mooner510.jcgbackend.domain.question.service

import kr.mooner510.jcgbackend.domain.question.data.dto.response.Lesson
import kr.mooner510.jcgbackend.domain.question.data.dto.response.Questions
import kr.mooner510.jcgbackend.domain.question.data.json.QuestionData
import kr.mooner510.jcgbackend.global.error.exception.LessonNotFoundException
import kr.mooner510.jcgbackend.global.error.exception.QuestionNotFoundException
import org.springframework.stereotype.Service

@Service
class QuestionService {
    fun getQuestion(id: Int): Questions {
        return Questions(QuestionData.questionMap[id] ?: throw QuestionNotFoundException())
    }

    fun getLesson(id: Int): Lesson {
        return QuestionData.lessonMap[id] ?: throw LessonNotFoundException()
    }
}