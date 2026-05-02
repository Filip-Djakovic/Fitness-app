package net.etfbl.Benas;

import java.io.Serializable;
import java.util.Objects;

public class MessageBean implements Serializable{
	private static final long serialVersionUID = 579649995854482639L;
	
	private Integer id;
	private String text;
	private Integer isRead;
	private UserBean user;
	
	public MessageBean() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isRead, text, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageBean other = (MessageBean) obj;
		return Objects.equals(id, other.id) && Objects.equals(isRead, other.isRead) && Objects.equals(text, other.text)
				&& Objects.equals(user, other.user);
	}
	
	

}
