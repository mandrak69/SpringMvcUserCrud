package rs.engineering.javacourse.springMvcUserCrud.domain;

import java.io.Serializable;

import javax.persistence.Entity;
@Entity
public class City implements Serializable {
	private static final long serialVersionUID = 1L;;
	private long id;
	private String number;
	private String name;
	
	public City() {
	}
	
	

	public String getNumber() {
		return number;
	}

	public void setNumber(String string) {
		this.number = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [number=" + number + ", name=" + name + "]";
	}



	public long getId() {
		return id;
	}



	public void setId(long l) {
		this.id = l;
	}
	
}
