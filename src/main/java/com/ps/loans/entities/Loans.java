package com.ps.loans.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "loans")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Loans extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    private String mobileNumber;
    private String loanNumber;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
}
