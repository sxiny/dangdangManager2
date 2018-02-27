package src.com.baizhi.manager.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.com.baizhi.manager.dao.CategoryDao;
import src.com.baizhi.manager.entity.Category;
import src.com.baizhi.manager.entity.Category1;
import src.com.baizhi.manager.service.CategoryService;
@Service

public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDao dao;
	
	public Map getCate(int page, int rows) {
		Map map = new HashMap();
		int start = (page-1)*rows;
		List<Category1> list = dao.getAll(start,rows);
		for (Category1 category : list) {
			if(category.getPid()==null){
				
				category.setLevel(1);
			}else{
				category.setLevel(2);
			}
		}
		
		map.put("rows", list);
		map.put("total", dao.getCount());
		return map;
	}

	public List<Category> getFirst() {
		
		
		return dao.getFirst();
	}

	public boolean addCategory(Category category) {
		
		int result = dao.addCategory(category);
		if(result > 0){
			
			return true;
		}
		
		return false;
	}

	public Category getOne(int id) {
		
		return dao.getOne(id);
	}

	public boolean updateCategory(Category category) {
		
		int result = dao.update(category);
		if(result > 0){
			
			return true;
		}
		
		return false;
	}

	public boolean delete(int[] ids) {
		
		int result = dao.delete(ids);
		if(result > 0){
			
			return true;
		}
		return false;
		
	}

	public List<Category> getSecond() {
		return dao.getSecond();
	}

}
