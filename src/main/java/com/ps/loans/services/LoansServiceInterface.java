package com.ps.loans.services;

import com.ps.loans.dto.LoansDto;

public interface LoansServiceInterface {

    /**
     *
     * @param mobileNumber - Mobile Number
     */
    void createLoan(String mobileNumber);

    /**
     *
     * @param mobileNumber - Input mobile Number
     *  @return LoansDto
     */
    LoansDto fetchLoan(String mobileNumber);

    /**
     *
     * @param loansDto - LoansDto Object
     * @return boolean
     */
    boolean updateLoan(LoansDto loansDto);

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return boolean
     */
    boolean deleteLoan(String mobileNumber);

}
