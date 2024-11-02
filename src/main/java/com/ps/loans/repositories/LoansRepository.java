package com.ps.loans.repositories;

import com.ps.loans.dto.LoansDto;
import com.ps.loans.entities.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long>{

    boolean existsByMobileNumber(String mobileNumber);

    Optional<Loans> findByMobileNumber(String mobileNumber);

    Optional<Loans> findByLoanNumber(String loanNumber);
}
