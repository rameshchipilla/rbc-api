package git.rbc.api.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

public class PetModel extends BaseModel {

	private static final long serialVersionUID = 2537373112835147458L;

	@NotNull
	private String name;

	@NonNull
	private String color;

	@NotNull
	@Max(1)
	private String gender;

	@NonNull
	private String type;

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
