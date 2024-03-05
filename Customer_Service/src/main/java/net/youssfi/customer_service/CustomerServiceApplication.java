package net.youssfi.customer_service;

import net.youssfi.customer_service.config.GlobalConfig;
import net.youssfi.customer_service.entities.Customer;
import net.youssfi.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository ){
		return args -> {

			List<Customer> customerList = List.of(
					        Customer.builder()
							.firstName("houssain")
							.lastName("haiboub")
							.email("houssain@gmail.com")

							.build(),
					Customer.builder()
							.firstName("mouad ")
							.lastName("java")
							.email("mouad@gamil.com")
							.build()

			);
			customerRepository.saveAll(customerList);

			Customer customer = Customer.builder()
					.firstName("youssef")
					.lastName("youssfi")
					.email("youssef@gmail.com")

					.build();

			customerRepository.save(customer);
		};
	}



}
