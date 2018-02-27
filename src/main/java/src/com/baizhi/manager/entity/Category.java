package src.com.baizhi.manager.entity;

public class Category {
	private Integer id;
	
	private String name;
	
	private Integer pid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", pid=" + pid + "]";
	}
	
	
}
