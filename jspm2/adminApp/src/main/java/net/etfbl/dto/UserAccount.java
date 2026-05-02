package net.etfbl.dto;

import java.io.Serializable;
import java.util.Objects;

public class UserAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6100840818145542386L;

	public UserAccount() {
	}
	
	private String username;
	private String password;
	private int isActivated;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsActivated() {
		return isActivated;
	}
	public void setIsActivated(int isActivated) {
		this.isActivated = isActivated;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(isActivated, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount other = (UserAccount) obj;
		return isActivated == other.isActivated && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
	

}
