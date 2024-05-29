package dev.ramanuj.prom_grafana;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Sample Ecommerce App", version = "1.0.0", description = "Demo of monitoring using prometheus with Grafana"))
public class PromGrafanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromGrafanaApplication.class, args);
	}

}
