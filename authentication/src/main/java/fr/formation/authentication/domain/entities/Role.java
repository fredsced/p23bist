package fr.formation.authentication.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends AbstractEntity {

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "by_default", nullable = false)
    private boolean byDefault;

    public Role() {
	//
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public boolean isByDefault() {
	return byDefault;
    }

    public void setByDefault(boolean byDefault) {
	this.byDefault = byDefault;
    }

    @Override
    public String toString() {
	return "Role [id=" + getId() + ", code=" + code + ", byDefault="
		+ byDefault + "]";
    }
}
