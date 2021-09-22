package guru.springframework.sfgdi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
/*
The @ConfigurationProperties annotation will find all properties starting with the provided name (guru in this case) and
attempt to bind them with the variables of the class.  This requires their name and type to match.
 */
@ConfigurationProperties("guru")
public class SfgConfiguration {
    private String userName;
    private String password;
    private String jdbcUrl;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }
}
