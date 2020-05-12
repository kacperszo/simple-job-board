package szot.pl.simplejobboard.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * The Role class is the representation of the single role in the system.
 *
 * @author Kacper Szot
 */
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String authority;

    /**
     * @param id id of the role
     * @param authority
     */
    public Role(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public Role() {

    }

    /**
     * Get the current value of the id property.
     *
     * @return the value of the id property.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the current value of the id property
     *
     * @param id the new value of the id property
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the current value of the authority property.
     *
     * @return the value of the authority property.
     */
    @Override
    public String getAuthority() {
        return authority;
    }

    /**
     * Set the current value of the authority property
     *
     * @param authority the new value of the authority property
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * The builder class for the role class
     */
    public static class Builder {
        private Long id;
        private String authority;

        /**
         * The method builds a new role object with properties based on the builder's properties.
         *
         * @return new Role object with properties based on builders properties
         */
        public Role build() {
            return new Role(id, authority);
        }

        /**
         * Set the current value of the id property
         * @param id the new value of the id property
         * @return self
         */
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * Set the current value of the authority property
         *
         * @param authority the new value of the authority property
         * @return self
         */
        public Builder authority(String authority) {
            this.authority = authority;
            return this;
        }
    }
}
