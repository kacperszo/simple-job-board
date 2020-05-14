package pl.szot.simplejobboard.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * advertisement data transfer object
 *
 * @author Kacper Szot
 */
public class AdvertisementDTO {
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotNull
    private LocalDateTime creationDate;
    @NotNull
    private LocalDateTime expirationDate;
    private boolean hidden;

    public AdvertisementDTO() {
    }

    public AdvertisementDTO(Long id, String title, String content, LocalDateTime creationDate, LocalDateTime expirationDate, boolean hidden) {
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

    /**
     * The builder class for the advertisement data transfer object class
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
        public AdvertisementDTO build() {
            return new AdvertisementDTO(id, title, content, creationDate, expirationDate, hidden);
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
