package com.nextgen.test.bookShop.restController.impl

import com.nextgen.test.bookShop.domain.dto.BookDto
import com.nextgen.test.bookShop.domain.entities.Book
import com.nextgen.test.bookShop.domain.enum.Gender
import com.nextgen.test.bookShop.request_settings.RequestResult
import com.nextgen.test.bookShop.restController.BookAPI
import com.nextgen.test.bookShop.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class BookApiImpl(

    @Autowired
    private val service: BookService
): BookAPI {

    override fun addBook(dto: BookDto): RequestResult<Book?> {
        return try {
            RequestResult.success(service.addBook(dto), 200)
        } catch (e: Exception) {
            RequestResult.error(null, 500, "Internal Error", e.localizedMessage)
        }
    }

    override fun getAllBooks(): RequestResult<List<Book>?> {
        return try {
            RequestResult.success(service.getAllBooks(), 200)
        } catch (e: Exception) {
            RequestResult.error(null, 500, "Internal Error", e.localizedMessage)
        }
    }

    override fun searchByTitle(title: String): RequestResult<List<Book>?> {
        return try {
            RequestResult.success(service.searchByTitle(title), 200)
        } catch (e: Exception) {
            RequestResult.error(null, 500, "Internal Error", e.localizedMessage)
        }
    }

    override fun searchByAuthor(author: String): RequestResult<List<Book>?> {
        return try {
            RequestResult.success(service.searchByAuthor(author), 200)
        } catch (e: Exception) {
            RequestResult.error(null, 500, "Internal Error", e.localizedMessage)
        }
    }

    override fun searchByGender(gender: Gender): RequestResult<List<Book>?> {
        return try {
            RequestResult.success(service.searchByGender(gender), 200)
        } catch (e: Exception) {
            RequestResult.error(null, 500, "Internal Error", e.localizedMessage)
        }
    }
}