package kr.mooner510.jcgbackend.global.error.filter

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import kr.mooner510.jcgbackend.global.error.data.ErrorResponse
import kr.mooner510.jcgbackend.global.error.data.GlobalError
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (err: GlobalError) {
            response.status = err.errorCode.status.value()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.characterEncoding = "UTF-8"
            objectMapper.writeValue(
                response.writer, ErrorResponse(
                    err.errorCode.ordinal,
                    err.errorCode.message,
                    err.data
                )
            )
        }
    }


}