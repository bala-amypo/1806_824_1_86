public class JwtTokenProvider {

    public String createToken(Long id,String email,String role){
        return id+":"+email+":"+role;
    }
    public boolean validateToken(String t){ return t!=null; }
    public String getEmail(String t){ return t.split(":")[1]; }
    public Long getUserId(String t){ return Long.valueOf(t.split(":")[0]); }
    public String getRole(String t){ return t.split(":")[2]; }
}
