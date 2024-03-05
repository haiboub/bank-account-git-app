package net.youssfi.account_service.model;

import lombok.*;

@Getter @Setter @ToString
public class Customer {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
