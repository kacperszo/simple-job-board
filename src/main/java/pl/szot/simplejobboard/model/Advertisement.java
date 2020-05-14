package pl.szot.simplejobboard.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The Advertisement class is the representation of the single advertisement in the system.
 *
 * @author Kacper Szot
 */
@Entity
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @Lob
    @NotBlank
    private String content;
    @CreationTimestamp
    private LocalDateTime creationDate;
    @NotNull
    private LocalDateTime expirationDate;
    private boolean hidden;

    public Advertisement() {
    }

    public Advertisement(Long id, String title, String content, LocalDateTime creationDate, LocalDateTime expirationDate, boolean hidden) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.hidden = hidden;
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
     * Get the current value of the title property.
     *
     * @return the value of the title property
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the current value of the title property.
     *
     * @param title the new value of the title property
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the current value of the content property.
     *
     * @return the current value of the content property
     */
    public String getContent() {
        return content;
    }

    /**
     * Set the current value of the content property.
     *
     * @param content the new value of the content property
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get the current value of the creationDate property.
     *
     * @return the current value of the creationDate property
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Set the current value of the creationDate property.
     *
     * @param creationDate the new value of the creationDate property
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Get the current value of the ExpirationDate property.
     *
     * @return the current value of the ExpirationDate property
     */
    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    /**
     * Set the current value of the expirationDate property.
     *
     * @param expirationDate the new value of the expirationDate property
     */
    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Get the current value of the hidden property.
     *
     * @return the current value of the hidden property
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * Set the current value of the hidden property.
     *
     * @param hidden the new value of the hidden property
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id) * -23;
    }

    /**
     * The builder class for the advertisement class
     */
    public static class Builder {
        private Long id;
        private String title;
        private String content;
        private LocalDateTime creationDate;
        private LocalDateTime expirationDate;
        private boolean hidden;

        /**
         * The method builds a new advertisement object with properties based on the builder's properties.
         *
         * @return new Advertisement object with properties based on builders properties
         */
        public Advertisement build() {
            return new Advertisement(id, title, content, creationDate, expirationDate, hidden);
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
         * Set the current value of the title property
         *
         * @param title the new value of the title property
         * @return self
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        /**
         * Set the current value of the content property
         *
         * @param content the new value of the content property
         * @return self
         */
        public Builder content(String content) {
            this.content = content;
            return this;
        }

        /**
         * Set the current value of the creationDate property
         *
         * @param creationDate the new value of the creationDate property
         * @return self
         */
        public Builder creationDate(LocalDateTime creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        /**
         * Set the current value of the expirationDate property
         *
         * @param expirationDate the new value of the expirationDate property
         * @return self
         */
        public Builder expirationDate(LocalDateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        /**
         * Set the current value of the hidden property
         *
         * @param hidden the new value of the hidden property
         * @return self
         */
        public Builder hidden(boolean hidden) {
            this.hidden = hidden;
            return this;
        }
    }
}
