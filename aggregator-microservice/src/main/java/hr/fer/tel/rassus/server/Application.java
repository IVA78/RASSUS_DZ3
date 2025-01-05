package hr.fer.tel.rassus.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "hr.fer.tel.rassus.server")
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
