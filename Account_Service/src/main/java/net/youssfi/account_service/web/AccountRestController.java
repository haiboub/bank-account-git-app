package net.youssfi.account_service.web;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.youssfi.account_service.clients.CustomerRestClients;
import net.youssfi.account_service.entities.BankAccount;
import net.youssfi.account_service.model.Customer;
import net.youssfi.account_service.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClients customerRestClients;

    public AccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClients customerRestClients) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClients = customerRestClients;
    }


    @GetMapping("/accounts")
    public List<BankAccount> bankAccountList(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount findBankaccountById(@PathVariable String id){
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClients.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
