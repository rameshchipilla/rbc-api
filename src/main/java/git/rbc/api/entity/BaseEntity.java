
package git.rbc.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Simple Java bean domain object with an id property. Used as a base class for
 * objects needing this property.
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1370236644540574112L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isNew() {
		return this.id == null;
	}
}
