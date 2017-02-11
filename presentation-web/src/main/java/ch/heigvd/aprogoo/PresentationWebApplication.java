package ch.heigvd.aprogoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The entry point of Spring Boot.
 *
 * Several annotations have been added in order to reference the components in the other modules.
 *
 * @author Jämes Ménétrey
 * @version 1.0-SNAPSHOT
 */
@EntityScan("ch.heigvd.aprogoo")
@ComponentScan(basePackages="ch.heigvd.aprogoo")
@EnableJpaRepositories(basePackages="ch.heigvd.aprogoo")
@SpringBootApplication(scanBasePackages = "ch.heigvd.aprogoo")
public class PresentationWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PresentationWebApplication.class, args);
    }
}