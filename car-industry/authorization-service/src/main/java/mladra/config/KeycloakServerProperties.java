package mladra.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "keycloak.server")
public class KeycloakServerProperties {
    String contextPath = "/auth";
    String realmImportFile = "car-industry-realm.json";
    String realmName = "car-industry";
    AdminUser adminUser = new AdminUser();

    @Getter
    @Setter
    public static class AdminUser {
        String username = "admin";
        String password = "admin";
    }
}
