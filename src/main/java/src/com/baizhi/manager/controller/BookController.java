package src.com.baizhi.manager.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import src.com.baizhi.manager.entity.Book;
import src.com.baizhi.manager.service.BookService;
import src.com.baizhi.manager.util.util.FIleTrasfer;

@Controller
@RequestMapping("/main")
public class BookController {
	@Autowired
	private BookService service;
	@RequestMapping("/showBook")
	public @ResponseBody Map getAllBook(int rows,int page){
		
		return service.getAllBook(rows,page);
	}
	@RequestMapping("/addBook")
	public @ResponseBody boolean insert(Book b,MultipartFile file,
			HttpServletRequest request,@ModelAttribute("filename")String filename) throws IllegalStateException, IOException{
		String fileTrtans = FIleTrasfer.fileTrtans(request, file);
		b.setImg(fileTrtans);
		boolean isAdd=service.addBook(b); 
		return isAdd;
	}
	@RequestMapping("/updateBook")
	public @ResponseBody boolean update(Book b,MultipartFile file,
			HttpServletRequest request,@ModelAttribute("filename")String filename){
		String fileTrtans = FIleTrasfer.fileTrtans(request, file);
		b.setImg(fileTrtans);
		boolean isUpdate = service.updateBook(b);
		return isUpdate;
	}
	@RequestMapping("/deleteBook")
	public @ResponseBody boolean deleteBook(int[] ids){
		
		return service.deleteBook(ids);
	}
	//Í¼Æ¬ÐÞ¸Ä»ØÏÔ
	@RequestMapping("/changeImg")
	public @ResponseBody String changeImg(MultipartFile file,
			HttpServletRequest request,@ModelAttribute("filename")String filename){
		filename = FIleTrasfer.fileTrtans(request, file);
		return filename;
		}
	}
