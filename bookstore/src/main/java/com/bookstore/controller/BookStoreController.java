package com.bookstore.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.bookstore.constants.Category;
import com.bookstore.domain.Book;
import com.bookstore.service.BookStoreService;
import com.bookstore.service.dto.BookDto;
import com.bookstore.service.dto.SellDto;

import java.util.List;
import java.util.Map;

/**
 * Controller for the bookstore projects
 * Acceptance Criterias:
 * 1)Add a book
 * 2)get books by Id
 * 3)get all books
 * 4)get number of books available by Id
 * 5)update a book
 * 6)sell a book
 * 7)sell a list of books
 * 8)get book(s) by category/keywords
 * 9)get number of books sold per category/keyword
 */
@RestController
@RequestMapping("/api")
@Api(value = "Bookstore Controller", description = "Bookstore REST Endpoints.")
public class BookStoreController {

    private final BookStoreService bookStoreService;

    @Autowired
    public BookStoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    /**
     * AC:  1)Add a book
     * This add new book with new Identifier.
     *
     * @param bookDto
     */
    @ApiOperation(value = "Add New Book")
    @PostMapping("/add-new-book")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewBook(@Validated @RequestBody BookDto bookDto) {
    	System.out.println("$$$$$$ " + Category.valueOf(bookDto.getCategoryItem()));
    	BookDto newBookDto = new BookDto();
    	newBookDto.setAuthor(bookDto.getAuthor());
    	newBookDto.setCategory(Category.valueOf(bookDto.getCategoryItem()));
    	newBookDto.setPrice(bookDto.getPrice());
    	newBookDto.setTitle(bookDto.getTitle());
    	newBookDto.setTotalCount(bookDto.getTotalCount());
    	newBookDto.setId(bookDto.getId());
    	newBookDto.setImageURL(bookDto.getImageURL());
        bookStoreService.addNewBook(newBookDto);
    }

    /**
     * AC: 1)Add a book
     * This method add quantity of book to the books which are already registered.
     *
     * @param id
     * @param quantityToAdd
     */
    @ApiOperation(value = "Add books")
    @PutMapping("/add-book/{id}/{quantityToAdd}")
    @ResponseStatus(HttpStatus.OK)
    public void addBook(@PathVariable Integer id,
                        @PathVariable int quantityToAdd) {
        bookStoreService.addBook(id, quantityToAdd);
    }

    /**
     * AC: 2)get books by id
     *
     * @param id
     * @return bookDto
     */
    @ApiOperation(value = "Get Book By Id")
    @GetMapping("/book/{id}")
    public BookDto getBookById(@PathVariable Integer id) {
        return bookStoreService.getBookById(id);
    }


    /**
     * AC: 3)Get All Books
     *
     * @return List<BookDto>
     */
    @ApiOperation(value = "Get All Books")
    @GetMapping("/book-list")
    public List<BookDto> getAllBooks() {
        return bookStoreService.getAllBooks();
    }

    /**
     * AC: 4) Get number of books available by id.
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "Get Number of books by Id")
    @GetMapping("/number-of-books/{id}")
    public int getNumberOfBooksById(@PathVariable Integer id) {
        return bookStoreService.getNumberOfBooksById(id);
    }

    /**
     * AC: 5) Update a book.
     */
    @ApiOperation(value = "Update a book")
    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@PathVariable Integer id,
                           @Validated @RequestBody BookDto bookDto) {
    	BookDto newBookDto = new BookDto();
    	newBookDto.setAuthor(bookDto.getAuthor());
    	newBookDto.setCategory(Category.valueOf(bookDto.getCategoryItem()));
    	newBookDto.setPrice(bookDto.getPrice());
    	newBookDto.setTitle(bookDto.getTitle());
    	newBookDto.setTotalCount(bookDto.getTotalCount());
    	newBookDto.setImageURL(bookDto.getImageURL());
        bookStoreService.updateBook(id, newBookDto);
    }

    /**
     * AC: 6) Sell a single book
     *
     * @param id
     */
    @ApiOperation(value = "Sell a book")
    @PutMapping("/sell-book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void sellBook(@PathVariable Integer id) {
        bookStoreService.sellBook(id);
    }

    /**
     * AC: 7) Sell list of books
     * SellDto has both book identifier and quantity that bookstore is selling
     *
     * @param sellDto
     */
    @ApiOperation(value = "Sell List of Books.")
    @PutMapping("/sell-books")
    @ResponseStatus(HttpStatus.OK)
    public void sellBooks(@Validated @RequestBody List<SellDto> sellDto) {
        bookStoreService.sellBooks(sellDto);
    }

    /**
     * AC:8 Get Books by category/keyword
     *
     * @param category Respresnts Different Category of book. EG: NONFICTION, ACTION, ETC. Check the category enum
     * @param keyword  Assuming keyword to be any search value. This will be used to search on title, author or id of the book
     * @return
     */
    @ApiOperation(value = "Get Book by Category and Keyword")
    @GetMapping("/books")
    public List<BookDto> getBookByCategoryKeyWord(@RequestParam String keyword,
                                                  @RequestParam Category category) {
        return bookStoreService.getBookByCategoryKeyWord(keyword, category);
    }

    /**
     * AC:9 Get Number of books sold per category/keyword
     *
     * @param keyword
     * @param category
     * @return
     */
    @ApiOperation(value = "Get Number of Books Sold Per Category/Keyword")
    @GetMapping("/number-of-books")
    public int getNumberOfBooksSoldByCategoryAndKeyword(@RequestParam String keyword,
                                                        @RequestParam Category category) {
        return bookStoreService.getNumberOfBooksSoldByCategoryAndKeyword(keyword, category);
    }
    
    @DeleteMapping("/book/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) throws Exception {
    	BookDto bdto  = bookStoreService.getBookById(id);
    	Book b = new Book();
    	b.setAuthor(bdto.getAuthor());
    	b.setCategory(bdto.getCategory());
    	b.setId(bdto.getId());
    	b.setImageURL(bdto.getImageURL());
    	b.setPrice(bdto.getPrice());
    	b.setTitle(bdto.getTitle());
    	b.setTotalCount(bdto.getTotalCount());
    	System.out.println(">>>>> " + bdto.getTitle());
    	bookStoreService.deleteBook(b);
        return "success";
    }

}
