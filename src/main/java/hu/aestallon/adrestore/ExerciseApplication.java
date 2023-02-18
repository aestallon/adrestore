package hu.aestallon.adrestore;

import hu.aestallon.adrestore.config.BootStrapConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({BootStrapConfig.class})
public class ExerciseApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExerciseApplication.class, args);
  }

}
