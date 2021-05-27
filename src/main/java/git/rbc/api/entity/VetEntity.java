package git.rbc.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "VET")
public class VetEntity extends BaseEntity {

	private static final long serialVersionUID = -7469042303817867069L;

	@NotNull
	@Size(max = 50)
	@Column(name = "VET_FIRST_NAME")
	private String firstName;

	@NotNull
	@Size(max = 50)
	@Column(name = "VET_LAST_NAME")
	private String lastName;

	@NotNull
	@Size(max = 1)
	@Column(name = "VET_GENDER")
	private String gender;

	@NotNull
	@Size(max = 50)
	@Column(name = "VET_EMAIL")
	private String email;

	@NotNull
	@Size(max = 10)
	@Column(name = "VET_PHONE")
	private String phone;

	@Column(name = "LAST_UPDATE_TS", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = true)
	private Date lastUpdateTs = new Date();

	@Column(name = "CREATION_TS", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Date createTs;

	@PreUpdate
	protected void onUpdate() {
		lastUpdateTs = new Date();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}