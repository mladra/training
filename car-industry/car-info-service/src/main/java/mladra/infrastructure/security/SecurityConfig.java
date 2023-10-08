package mladra.infrastructure.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    private static final String SCOPE_READ = "SCOPE_read";
    private static final String SCOPE_WRITE = "SCOPE_write";

    @Value("${spring.security.oauth2.car-info-service.opaque.introspection-uri}")
    String introspectionUri;

    @Value("${spring.security.oauth2.car-info-service.opaque.introspection-client-id}")
    String clientId;

    @Value("${spring.security.oauth2.car-info-service.opaque.introspection-client-secret}")
    String clientSecret;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        return security
                .authorizeHttpRequests(this::customizeEndpointsPrivileges)
                .oauth2ResourceServer(this::customizeOpaqueToken)
                .build();
    }

    private AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry customizeEndpointsPrivileges(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry customizer) {
        return customizer
                .requestMatchers(new AntPathRequestMatcher("/cars/**", HttpMethod.GET.name())).hasAuthority(SCOPE_READ)
                .requestMatchers(new AntPathRequestMatcher("/cars/", HttpMethod.POST.name())).hasAuthority(SCOPE_WRITE)
                .requestMatchers(new AntPathRequestMatcher("/cars/", HttpMethod.PUT.name())).hasAuthority(SCOPE_WRITE)
                .anyRequest().authenticated();
    }

    private OAuth2ResourceServerConfigurer<HttpSecurity> customizeOpaqueToken(OAuth2ResourceServerConfigurer<HttpSecurity> oauth2) {
        return oauth2.opaqueToken(token -> token.introspectionUri(this.introspectionUri).introspectionClientCredentials(this.clientId, this.clientSecret));
    }

}
