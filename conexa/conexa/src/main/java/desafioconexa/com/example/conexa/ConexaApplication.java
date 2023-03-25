package desafioconexa.com.example.conexa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "desafioconexa.com.example.conexa"})
@EnableFeignClients
@EnableJpaRepositories(basePackages = "desafioconexa.com.example.conexa.repositories")
@EntityScan(basePackages = "desafioconexa.com.example.conexa.entities")

public class ConexaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConexaApplication.class, args);
	}

}
