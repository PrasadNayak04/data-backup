package com.robosoft.OnlineBookStore.Controller;

import com.robosoft.OnlineBookStore.Modal.Book;
import com.robosoft.OnlineBookStore.Service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    AdminService adminService;

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book){
        return adminService.addBook(book);
    }

    @DeleteMapping("/removebook")
    public String removeBook(@PathVariable String bookName){
        return adminService.removeBook(bookName);
    }

    @GetMapping("/viewbooks")
    public List<Book> viewAvailableBooks(){
        return adminService.viewAllBooks();
    }

    @PutMapping("updatebookamount/{bookName}/{newAmount}")
    public String updateBookAmount(@PathVariable String bookName, @PathVariable double newAmount){
        return adminService.updateBookAmount(bookName, newAmount);
    }

}
