package src.com.baizhi.manager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.com.baizhi.manager.dao.BookDao;
import src.com.baizhi.manager.entity.Book;
import src.com.baizhi.manager.service.BookService;
@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao dao;

	public Map getAllBook(int rows, int page) {
		Map map = new HashMap();
		int start = (page-1)*rows;
		List<Book> list = dao.getAll(start,rows);
		map.put("rows", list);
		map.put("total", dao.getCount());
		
		return map;
	}

	public boolean addBook(Book b) {
		
		int result = dao.addBook(b);
		if(result>0){
			
			return true;
		}
		
		return false;
	}

	public boolean updateBook(Book b) {
		int result = dao.update(b);
			if(result>0){
			
			return true;
		}
		
		return false;
	}
	public boolean deleteBook(int[] ids) {
		int result = dao.deleteBook(ids);
		if(result>0){
			
			return true;
		}
		
		return false;
	}

}
