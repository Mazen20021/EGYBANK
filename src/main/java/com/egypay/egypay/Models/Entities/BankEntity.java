package com.egypay.egypay.Models.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "banks")

public class BankEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "swift")
    private String swift;
    @Column(name = "iban")
    private String iban;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "request_Id")
    private String requestId;

}
