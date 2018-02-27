package src.com.baizhi.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import src.com.baizhi.manager.entity.Category;
import src.com.baizhi.manager.entity.Category1;

public interface CategoryDao {

	List<Category1> getAll(@Param("start")int start, @Param("rows")int rows);

	int getCount();

	List<Category> getFirst();

	int addCategory(Category category);

	Category getOne(int id);

	int update(Category category);

	int delete(int[] ids);

	List<Category> getSecond();

}
