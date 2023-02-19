package hu.aestallon.adrestore;

import hu.aestallon.adrestore.config.BootStrapConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Import({BootStrapConfig.class})
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
