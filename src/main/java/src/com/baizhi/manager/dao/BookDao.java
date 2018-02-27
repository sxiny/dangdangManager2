package src.com.baizhi.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import src.com.baizhi.manager.entity.Book;

public interface BookDao {

	List<Book> getAll(@Param("start")int start, @Param("rows")int rows);

	int getCount();

	int addBook(Book b);

	int update(Book b);

	int deleteBook(int[] ids);

}
