package net.youssfi.account_service.entities;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import jakarta.persistence.*;
import lombok.*;
import net.youssfi.account_service.enums.AccountType;
import net.youssfi.account_service.model.Customer;

import javax.xml.crypto.Data;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Builder
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient //ignore cette attribut
    private Customer customer;
    private Long customerId;

}
