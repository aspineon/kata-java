package net.sshplendid.study.java.whiteship;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class WhiteshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhiteshipApplication.class, args);
	}

	@Configuration
	class AppConfig {
		@Bean
		public ModelMapper modelMapper() {
			return new ModelMapper();
		}

	}
}
