package pl.szot.simplejobboard.requests;

/**
 * Class represents a single request performed to authenticate and get a jwt token
 *
 * @author Kacper Szot
 */
public class LoginRequest {
    private String username;
    private String password;

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
}
