package ks.msx.SpJava.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@org.springframework.context.annotation.Configuration
@AllArgsConstructor
@EnableWebSecurity
public class Configuration {


    @Bean
    public SecurityFilterChain filerChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(req -> req
                        .requestMatchers(WHITE_LIST_URLS).permitAll()
                        .requestMatchers(RESTRICTED_AREA).authenticated()
                        .anyRequest().permitAll())
                .formLogin(f -> f.permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }

    private static final String[] WHITE_LIST_URLS = {
            "/",
            "/save",
            "/send"
    };

    private static final String[] RESTRICTED_AREA = {

    };

}
