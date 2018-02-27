package src.com.baizhi.manager.service;

import java.util.Map;

import src.com.baizhi.manager.entity.Book;

public interface BookService {

	Map getAllBook(int rows, int page);

	boolean addBook(Book b);

	boolean updateBook(Book b);

	boolean deleteBook(int[] ids);

}
