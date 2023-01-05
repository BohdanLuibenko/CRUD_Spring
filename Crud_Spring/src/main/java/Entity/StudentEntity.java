package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String midlename;
	String lastname;

	public StudentEntity() {

	}

	public Long getId() {
		return id;
	}

	public String getLastname() {
		return lastname;
	}

	public String getMidlename() {
		return midlename;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setMidlename(String midlename) {
		this.midlename = midlename;
	}

	public void setName(String name) {
		this.name = name;
	}
}
