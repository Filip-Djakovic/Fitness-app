package net.etfbl.Benas;

import java.io.Serializable;
import java.util.Objects;

public class UserBean implements Serializable{
	private static final long serialVersionUID = 2161035958482109114L;
	private Integer id;
	private String name;
	private String surname;
	private String city;
	private String mail;
	private UserAccountBean userAccount;
	public UserBean() {
		
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public UserAccountBean getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccountBean userAccount) {
		this.userAccount = userAccount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(city, id, mail, name, surname, userAccount);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBean other = (UserBean) obj;
		return Objects.equals(city, other.city) && Objects.equals(id, other.id) && Objects.equals(mail, other.mail)
				&& Objects.equals(name, other.name) && Objects.equals(surname, other.surname)
				&& Objects.equals(userAccount, other.userAccount);
	}
	
	

}
