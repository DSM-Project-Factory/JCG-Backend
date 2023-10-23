package kr.mooner510.jcgbackend.global.error.controller

import kr.mooner510.jcgbackend.global.error.data.ErrorResponse
import kr.mooner510.jcgbackend.global.error.data.GlobalError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(GlobalError::class)
    fun globalExceptionHandler(error: GlobalError): ResponseEntity<*> {
        return ResponseEntity.status(error.errorCode.status).body(
            ErrorResponse(
                error.errorCode.ordinal,
                error.errorCode.message,
                error.data
            )
        )
    }

    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun missingServletRequestParameterException(e: MissingServletRequestParameterException): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ErrorResponse(
                -1,
                e.message,
                e.parameterName
            )
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ErrorResponse(
                -2,
                e.bindingResult.allErrors[0].defaultMessage.toString(),
                e.bindingResult.allErrors[0].arguments?.get(0).toString()
            )
        )
    }
}