package com.nextgen.test.bookShop.service

import com.nextgen.test.bookShop.domain.dto.BookDto
import com.nextgen.test.bookShop.domain.entities.Book
import com.nextgen.test.bookShop.domain.enum.Gender
import org.springframework.stereotype.Service

@Service
interface BookService {

    fun addBook(dto: BookDto): Book?

    fun getAllBooks(): List<Book>?

    fun search(s: String): List<Book>?

    fun searchByTitle(title: String): List<Book>?

    fun searchByGender(gender: Gender): List<Book>?

    fun searchByAuthor(author: String): List<Book>?
}