package com.nano

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import io.micronaut.http.annotation.Body
import javax.validation.Valid

@Controller("/calculator")
@Validated
class MathController {

    @Get("/greeting")
    fun greeting(): HttpResponse<String> {
        return HttpResponse.ok("Hello world!")
    }

    @Post("/add", produces = [MediaType.APPLICATION_JSON])
    fun add(@Body @Valid request: Numbers): HttpResponse<AddResponse> {
        val result = request.first + request.second
        val response = AddResponse(result)
        return HttpResponse.ok(response)
    }
    data class AddResponse(val result: Int)

    @Post("/subtract", produces = [MediaType.APPLICATION_JSON])
    fun subtract(@Body @Valid request: Numbers): HttpResponse<SubtractResponse> {
         val result = request.first - request.second
        val response = SubtractResponse(result)
        return HttpResponse.ok(response)
    }
     data class SubtractResponse(val result: Int)
}
