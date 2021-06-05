package fr.formation.authentication.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account extends AbstractEntity {

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @JoinColumn(name = "role_id", nullable = false)
    @ManyToOne
    private Role role;

    public Account() {
	//
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    /**
     * Returns a string representation of this {@code account} printing all the
     * state of the object. Note that the implementation hides the password for
     * security reasons.
     *
     * @return a string representation of this {@code account}
     */
    @Override
    public String toString() {
	return "Account [id=" + getId() + ", username=" + username
		+ ", password=PROTECTED, enabled=" + enabled + ", role=" + role
		+ "]";
    }
}
