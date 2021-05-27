package git.rbc.api.model;

import java.io.Serializable;

public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1585313472654411899L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
