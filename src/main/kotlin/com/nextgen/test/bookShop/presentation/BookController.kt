package com.nextgen.test.bookShop.presentation

import com.nextgen.test.bookShop.domain.dto.BookDto
import com.nextgen.test.bookShop.domain.dto.UserLoginDto
import com.nextgen.test.bookShop.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class BookController(

    @Autowired
    private val service: BookService
) {

    @GetMapping("/listBooks")
    fun listBooks(model: Model): String {
        val books = service.getAllBooks()
        model.addAttribute("listBooks", books)
        return "redirect:books"
    }

    @PostMapping("/addBook")
    fun addBook(@ModelAttribute bookDto: BookDto): String {
        service.addBook(bookDto)
        return "redirect:/"
    }

    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("books", service.getAllBooks())
        model.addAttribute("dto", UserLoginDto())
        model.addAttribute("bookDto", BookDto())
        return "index"
    }

    @GetMapping("/searchBook")
    fun search(@RequestParam("search") search: String, model: Model): String {
        println("search books")
        model.addAttribute("books", service.search(search))
        model.addAttribute("dto", UserLoginDto())
        model.addAttribute("bookDto", BookDto())
        return "index"
    }
}