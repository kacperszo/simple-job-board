package pl.szot.simplejobboard.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
/**
 * Class represents a single request performed to create advertisement
 *
 * @author Kacper Szot
 */
public class CreateAdvertisementRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotNull
    private LocalDateTime expirationDate;
    @NotNull
    private Boolean hidden;

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
