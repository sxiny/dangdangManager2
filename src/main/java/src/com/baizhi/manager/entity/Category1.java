package src.com.baizhi.manager.entity;

public class Category1 {
	private Integer id;
	private String  name;
	private Integer pid;
	private Integer count;
	private int level;
	private String pname;
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", pid=" + pid
				+ ", count=" + count + ", pname=" + pname + "]";
	}
	
	
	
}
