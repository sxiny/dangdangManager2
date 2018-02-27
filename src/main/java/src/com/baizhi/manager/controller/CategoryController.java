package src.com.baizhi.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import src.com.baizhi.manager.entity.Category;
import src.com.baizhi.manager.service.CategoryService;

@Controller
@RequestMapping("/main")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	@RequestMapping("/showCate")
	public @ResponseBody Map getCate(int page,int rows){
		
		return service.getCate(page,rows);
		
	}
	@RequestMapping("/getLevel1")
	public @ResponseBody List<Category> getFirst(){
		
		return service.getFirst();
	}
	@RequestMapping("/getLevel2")
	public @ResponseBody List<Category> getSecond(){
		
		return service.getSecond();
	}
	@RequestMapping("/addCategory")
	public @ResponseBody boolean addCategory(Category category){
		System.out.println(category);
		
		return service.addCategory(category);
	}
	@RequestMapping("/getOne")
	public Category getOne(int id){
		
		return service.getOne(id);
	}
	@RequestMapping("/updateCategory")
	public @ResponseBody boolean upCategory(Category category){
		
		
		return service.updateCategory(category);
	}
	@RequestMapping("/delete")
	public @ResponseBody boolean delete(int[] ids){
		
		
		return service.delete(ids);
	}
	
}
