package pl.szot.simplejobboard.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * The User class is the representation of the single user in the system.
 *
 * @author Kacper Szot
 */
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private boolean enabled;
    private boolean expired;
    private boolean locked;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> authorities;

    /**
     * @param id          the user's id
     * @param username    the user's username
     * @param password    the user's password
     * @param email       the user's email
     * @param enabled     if user is enabled is set to true otherwise to false
     * @param expired     if user is expired is set to true otherwise to false
     * @param locked      if user is locked is set to true otherwise to false
     * @param authorities the user's authorities
     */
    public User(Long id, String username, String password, String email, boolean enabled, boolean expired, boolean locked, List<Role> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.expired = expired;
        this.locked = locked;
        this.authorities = authorities;
    }

    public User() {
    }

    /**
     * Set the current value of the expired property
     * Expired account can not be used by user
     *
     * @param expired the new value of the expired property
     */
    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    /**
     * Set the current value of the locked property
     * Locked account can not be used by user
     *
     * @param locked the new value of the locked property
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * Get the current value of the id property.
     *
     * @return the current value of the id property
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
     * Get the current value of the email property.
     *
     * @return the current value of the email property
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the current value of the email property
     *
     * @param email the new value of the email property
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the current value of the authorities property.
     *
     * @return value of the authorities property.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Set the current value of the authorities property
     *
     * @param authorities the new value of the authorities property.
     */
    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    /**
     * Get the current value of the password property.
     *
     * @return value of the password property.
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Set the current value of the password property
     *
     * @param password the new value of the password property.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the current value of the username property.
     *
     * @return the current value of the username property.
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Set the current value of the username property
     *
     * @param username he new value of the username property.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * returns false if account is expired, or true if its not
     *
     * @return false if account is expired, or true if its not
     */
    @Override
    public boolean isAccountNonExpired() {
        return !expired;
    }

    /**
     * returns false if account is locked, or true if its not
     *
     * @return false if account is locked, or true if its not
     */
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    /**
     * returns false if credentials are expired, or true if  they are not
     * in this application case, we do not predict expired credentials
     * @return false if credentials are expired, or true if they are not
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * returns true if account is enabled, or false if its not
     *
     * @return true if account is enabled, or false if its not
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * set the current value of the enable property.
     *
     * @param enabled the current value of the enable property.
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * The builder class for the user class
     */
    public static class Builder {

        private Long id;
        private String username;
        private String password;
        private String email;
        private boolean enabled;
        private boolean expired;
        private boolean locked;
        private List<Role> authorities;

        /**
         * Create the new instance of the user class, with properties based on builder properties.
         *
         * @return new instance of the user class, with properties based on builder properties.
         */
        public User build() {
            return new User(id, username, password, email, enabled, expired, locked, authorities);
        }

        /**
         * Set the current value of the id property
         *
         * @param id the new value of the id property
         * @return self
         */
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        /**
         * Set the current value of the username property
         *
         * @param username the new value of the username property
         * @return self
         */
        public Builder username(String username) {
            this.username = username;
            return this;
        }

        /**
         * Set the current value of the password property
         *
         * @param password the new value of the password property
         * @return self
         */
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        /**
         * Set the current value of the email property
         *
         * @param email the new value of the email property
         * @return self
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        /**
         * Set the current value of the enabled property
         *
         * @param enabled the new value of the enabled enabled
         * @return self
         */
        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        /**
         * Set the current value of the expired property
         *
         * @param expired the new value of the expired enabled
         * @return self
         */
        public Builder expired(boolean expired) {
            this.expired = expired;
            return this;
        }

        /**
         * Set the locked value of the locked property
         *
         * @param locked the new value of the locked enabled
         * @return self
         */
        public Builder locked(boolean locked) {
            this.locked = locked;
            return this;
        }

        /**
         * Set the authorities value of the authorities property
         *
         * @param authorities the new value of the authorities enabled
         * @return self
         */
        public Builder authorities(List<Role> authorities) {
            this.authorities = authorities;
            return this;
        }
    }
}
