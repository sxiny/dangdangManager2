package src.com.baizhi.manager.entity;

public class User {
	
	private String userCount;
	private String password;
	private String userName;
	private int authority = 0;
	
	


	public void setAuthority(int authority) {
		this.authority = authority;
	}


	public String getUserCount() {
		return userCount;
	}

	public void setUserCount(String userCount) {
		this.userCount = userCount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userCount=" + userCount + ", password=" + password
				+ ", userName=" + userName + ", authority=" + authority + "]";
	}

}
