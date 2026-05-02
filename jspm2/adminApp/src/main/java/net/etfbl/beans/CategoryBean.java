package net.etfbl.beans;

import java.util.List;

import net.etfbl.dao.CategoryDAO;
import net.etfbl.dto.Category;

public class CategoryBean {

	public CategoryBean() {
		// TODO Auto-generated constructor stub
	}
	public List<Category> getAll(){
		return CategoryDAO.getAll();
	}
	public int update(Category category) {
		return CategoryDAO.update(category);
	}
	public int create(Category category) {
		return CategoryDAO.create(category);
	}
	public List<String> getAllStrings(){
		return CategoryDAO.getAllStrings();
	}
}
