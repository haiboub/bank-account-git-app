package net.youssfi.account_service;

import net.youssfi.account_service.entities.BankAccount;
import net.youssfi.account_service.enums.AccountType;
import net.youssfi.account_service.model.Customer;
import net.youssfi.account_service.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){

		return args -> {
			List<BankAccount> bankAccountList = List.of(
					BankAccount.builder()
							.balance(25550)
							.type(AccountType.ACCOUNT_ACCOUNT)
							.currency("MAD")
							.createAt(LocalDate.now())
							.customerId(Long.valueOf(1))
							.build(),
					BankAccount.builder()
							.balance(588852)
							.type(AccountType.SAVING_ACCOUNT)
							.currency("$")
							.createAt(LocalDate.now())
							.customerId(Long.valueOf(2))
							.build()


			);


		bankAccountRepository.saveAll(bankAccountList);
		};
	}
}
