package hu.aestallon.adrestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
//@Import({BootStrapConfig.class})
public class ExerciseApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExerciseApplication.class, args);
  }

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
        .csrf().disable()
        .cors().disable()
        .authorizeRequests()
        .antMatchers("/persons/**, /favicon.png")
        .permitAll()
        .anyRequest().permitAll()
        .and().build();
  }
}
