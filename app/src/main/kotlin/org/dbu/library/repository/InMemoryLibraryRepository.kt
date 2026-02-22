package org.dbu.library.repository

import org.dbu.library.model.Book
import org.dbu.library.model.Patron

class InMemoryLibraryRepository : LibraryRepository {

    private val books = mutableMapOf<String, Book>()
    private val patrons = mutableMapOf<String, Patron>()


    override fun addBook(book: Book): Boolean {
        if (books.containsKey(book.isbn)) return false
        books[book.isbn] = book
        return true
    }

    override fun findBook(isbn: String): Book? = books[isbn]

    override fun updateBook(book: Book) {
        books[book.isbn] = book
    }

    override fun addPatron(patron: Patron): Boolean {
        if (patrons.containsKey(patron.id)) return false
        patrons[patron.id] = patron
        return true
    }

    override fun findPatron(id: String): Patron? = patrons[id]

    override fun updatePatron(patron: Patron) {
        patrons[patron.id] = patron
    }

    override fun getAllBooks(): List<Book> = books.values.toList()
}