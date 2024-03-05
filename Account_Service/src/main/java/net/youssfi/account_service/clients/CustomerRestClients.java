package net.youssfi.account_service.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.youssfi.account_service.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClients {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable long id);

    @CircuitBreaker(name ="customerService",fallbackMethod = "getDefaultList")
    @GetMapping("/customers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(long id,Exception exception){
        Customer customer =new Customer();
        customer.setId(id);
        customer.setFirstName("No valide");
        customer.setLastName("Nom Valide");
        customer.setEmail("No valide");
        return customer;
    }
    default List<Customer> getDefaultList(Exception e){
        return List.of();
    }
}
