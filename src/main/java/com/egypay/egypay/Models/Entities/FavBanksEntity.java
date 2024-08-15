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
@Table(name = "favbanks")

public class FavBanksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "swiftcode")
    private String SwiftCode;
    @Column(name = "iban")
    private String IBAN;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "token")
    private String token;
//    @ManyToOne
//    @JoinColumn(name = "favbanks_id")
//    private BankEntity bankEntity;
}
