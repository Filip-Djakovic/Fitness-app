package net.etfbl.Benas;

import java.io.Serializable;
import java.util.Objects;

public class EmailBean implements Serializable{

	private static final long serialVersionUID = -2662021179529379657L;

	public EmailBean() {
		
	}
	
	private String mess;
	private String path;

	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(mess, path);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailBean other = (EmailBean) obj;
		return Objects.equals(mess, other.mess) && Objects.equals(path, other.path);
	}
	
	

}
