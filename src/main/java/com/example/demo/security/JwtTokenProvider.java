@Component
public class JwtTokenProvider {

    public String createToken(long userId, String email, String role) {
        return "dummy-token";
    }

    public String getEmail(String token) {
        return "test@email.com";
    }

    public Long getUserId(String token) {
        return 1L;
    }

    public String getRole(String token) {
        return "USER";
    }
}
