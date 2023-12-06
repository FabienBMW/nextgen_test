package com.nextgen.test.bookShop.restController

import com.nextgen.test.bookShop.domain.dto.BookDto
import com.nextgen.test.bookShop.domain.entities.Book
import com.nextgen.test.bookShop.domain.enum.Gender
import com.nextgen.test.bookShop.request_settings.RequestResult
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Api(description = "API for book operations")
@RestController
@RequestMapping("/api/")
interface BookAPI {

    @ApiOperation(value = "")
    @PostMapping("addBook")
    fun addBook(
        @RequestBody dto: BookDto
    ): RequestResult<Book?>

    @ApiOperation(value = "")
    @Secured("ROLE_USER")
    @GetMapping("getAllBooks")
    fun getAllBooks(): RequestResult<List<Book>?>

    @ApiOperation(value = "searchByTitle")
    @GetMapping("searchBookByTitle")
    fun searchByTitle(
        @RequestParam(name = "title") title: String
    ): RequestResult<List<Book>?>

    @ApiOperation(value = "searchByTitle")
    @GetMapping("searchBookByAuthor")
    fun searchByAuthor(
        @RequestParam(name = "author") author: String
    ): RequestResult<List<Book>?>

    @ApiOperation(value = "searchByTitle")
    @GetMapping("searchBookByGender")
    fun searchByGender(
        @RequestParam(name = "gender") gender: Gender
    ): RequestResult<List<Book>?>


}