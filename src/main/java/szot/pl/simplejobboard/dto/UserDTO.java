package szot.pl.simplejobboard.dto;

/**
 * user data transfer object
 *
 * @author Kacper Szot
 */
public class UserDTO {
    private Long id;
    private String username;
    private String email;

    /**
     * @param id       the user's id
     * @param username the user's username
     * @param email    the user's password
     */
    public UserDTO(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;

    }

    public UserDTO() {

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
     * Get the current value of the username property.
     *
     * @return the current value of the username property.
     */
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
     * The builder class for the userDTO class
     */
    public static class Builder {
        private Long id;
        private String username;
        private String email;

        /**
         * Create the new instance of the userDTO class, with properties based on builder properties.
         *
         * @return the new instance of the userDTO class, with properties based on builder properties.
         */
        public UserDTO build() {
            return new UserDTO(id, username, email);
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
         * Set the current value of the email property
         *
         * @param email the new value of the email property
         * @return self
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }
    }
}
