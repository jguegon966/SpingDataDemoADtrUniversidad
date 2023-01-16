package es.iesjandula.SpringDataDemo;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringDataDemoApplication{

	public static void main(String[] args)
	{
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

}
