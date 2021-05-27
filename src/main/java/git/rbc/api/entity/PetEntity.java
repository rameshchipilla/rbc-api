package git.rbc.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PET", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID", "PET_NAME" }) })
public class PetEntity extends BaseEntity {

	private static final long serialVersionUID = -3838776205543480181L;

	@NotNull
	@Size(max = 50)
	@Column(name = "PET_NAME")
	private String name;

	@NotNull
	@Size(max = 50)
	@Column(name = "PET_COLOR")
	private String color;

	@NotNull
	@Size(max = 1)
	@Column(name = "PET_GENDER")
	private String gender;

	@NotNull
	@Size(max = 50)
	@Column(name = "PET_TYPE")
	private String type;

	@Column(name = "LAST_UPDATE_TS", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = true)
	private Date lastUpdateTs = new Date();

	@Column(name = "CREATION_TS", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Date createTs;

	@PreUpdate
	protected void onUpdate() {
		lastUpdateTs = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}