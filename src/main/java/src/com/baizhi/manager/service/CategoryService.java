package src.com.baizhi.manager.service;

import java.util.List;
import java.util.Map;

import src.com.baizhi.manager.entity.Category;

public interface CategoryService {
	/**
	 * 获取所有类别
	 * @param page
	 * @param rows
	 * @return
	 */
	Map getCate(int page, int rows);
	/**
	 * 添加类别前获取所有1级类别的业务
	 * @return
	 */
	List<Category> getFirst();
	/**
	 * 添加了类别的业务
	 * @param category
	 * @return
	 */
	boolean addCategory(Category category);
	/**
	 * 修改前获取的业务
	 * @param id
	 * @return
	 */
	Category getOne(int id);
	/**
	 * 对类别进行修改的业务
	 * @param category
	 * @return
	 */
	boolean updateCategory(Category category);
	/**
	 * 删除多个
	 * @param ids
	 * @return
	 */
	boolean delete(int[] ids);
	/**
	 * 查询二级目录的业务
	 * @return
	 */
	List<Category> getSecond();

}
