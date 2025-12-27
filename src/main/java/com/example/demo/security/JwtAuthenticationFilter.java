public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider provider;

    public JwtAuthenticationFilter(JwtTokenProvider p){ this.provider=p; }

    protected void doFilterInternal(...) {}
}
