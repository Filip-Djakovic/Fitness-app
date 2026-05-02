package net.etfbl.dto;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable{

	private static final long serialVersionUID = -3215478676036472238L;

	public Category() {

	}
	private int id;
	private String name;
	private String attributes;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAttributes() {
		return attributes;
	}
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(attributes, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(attributes, other.attributes) && id == other.id && Objects.equals(name, other.name);
	}
	
	

}
