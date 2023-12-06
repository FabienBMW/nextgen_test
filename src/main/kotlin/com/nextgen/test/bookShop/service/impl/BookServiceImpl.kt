package com.nextgen.test.bookShop.service.impl

import com.nextgen.test.bookShop.domain.dto.BookDto
import com.nextgen.test.bookShop.domain.entities.Book
import com.nextgen.test.bookShop.domain.enum.Gender
import com.nextgen.test.bookShop.repository.BookRepository
import com.nextgen.test.bookShop.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.time.Year
import java.util.regex.Pattern

@Component
class BookServiceImpl(

    @Autowired
    private val repository: BookRepository
): BookService {

    override fun addBook(dto: BookDto): Book? {
        println("insertion of books")
        if (repository.findAllByAuthorAndTitleAndPublicationDate(
            dto.author, dto.title, dto.publicationDate
        ).isPresent)
            return null
        if (!Gender.entries.toTypedArray().contains(dto.gender))
            return null

        val regex = "^(19|20)\\d{2}$"
        val pattern = Pattern.compile(regex)
        val matcher = pattern.matcher(dto.publicationDate.toString())
        if (!(matcher.matches() && dto.publicationDate <= Year.now().value))
            return null

        val book = Book(System.nanoTime().toString(), dto.author, dto.title, dto.publicationDate, dto.gender.toString())
        return repository.save(book)
    }

    override fun getAllBooks(): List<Book>? {
        return repository.findAll()
    }

    override fun search(s: String): List<Book>? {
        if (s == "")
            return getAllBooks()
        val response: MutableList<Book> = mutableListOf()
        response.addAll(repository.findAllByAuthorContainingIgnoreCase(s))
        repository.findAllByGenderContainingIgnoreCase(s).forEach {
            if (!response.contains(it))
                response.add(it)
        }
        repository.findAllByTitleContainingIgnoreCase(s).forEach {
            if (!response.contains(it))
                response.add(it)
        }
        return response
    }

    override fun searchByTitle(title: String): List<Book> {
        return repository.findAllByTitleContainingIgnoreCase(title)
    }

    override fun searchByGender(gender: Gender): List<Book>? {
        if (!Gender.entries.toTypedArray().contains(gender))
            return null
        return repository.findAllByGenderContainingIgnoreCase(gender.value())
    }

    override fun searchByAuthor(author: String): List<Book>? {
        return repository.findAllByAuthorContainingIgnoreCase(author)
    }
}