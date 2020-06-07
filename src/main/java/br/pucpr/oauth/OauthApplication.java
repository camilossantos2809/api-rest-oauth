package br.pucpr.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;

@SpringBootApplication
public class OauthApplication {
    // https://spring.io/guides/tutorials/rest/
    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class, args);
    }

}
