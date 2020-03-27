package rs.engineering.javacourse.springMvcUserCrud.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Company implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String address;
	private String number;
	private City city;

	public Company() {
	}

	

	



	public Company(Long id, String name, String address, String number, City city) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.setNumber(number);
		this.city = city;
	}







	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + "]";
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}







	public String getNumber() {
		return number;
	}







	public void setNumber(String number) {
		this.number = number;
	}
}
