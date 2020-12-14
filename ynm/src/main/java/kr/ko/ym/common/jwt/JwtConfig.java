package kr.ko.ym.common.jwt;

import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

     @Value("${application.jwt.secretKey}")
     private String secretKey;

     @Value("${application.jwt.tokenPrefix}")
     private String tokenPrefix;

    @Value("${application.jwt.tokenExpirationAfterDays}")
     private Integer tokenExpirationAfterDays;

     @Value("${application.git.oauth.token}")
     private String oauthToken;

    @Value("${application.git.repo.name}")
    private String repoName;

    public JwtConfig() {

    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public Integer getTokenExpirationAfterDays() {
        return tokenExpirationAfterDays;
    }

    public void setTokenExpirationAfterDays(Integer tokenExpirationAfterDays) {
        this.tokenExpirationAfterDays = tokenExpirationAfterDays;
    }

    public String getOauthToken() {
        return oauthToken;
    }

    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getAuthorizaionHeader(){
        return HttpHeaders.AUTHORIZATION;
    }
}
