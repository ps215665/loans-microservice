package com.ps.loans.controllers;

import com.ps.loans.config.ApiConfig;
import com.ps.loans.constants.LoansConstants;
import com.ps.loans.dto.LoansDto;
import com.ps.loans.dto.ResponseDto;
import com.ps.loans.services.LoansServiceInterface;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/api")
@Validated
public class LoansController {

    private final LoansServiceInterface loansService;
    private final ApiConfig apiConfig;

    public LoansController(
        LoansServiceInterface loansService,
        ApiConfig apiConfig
    ) {
        this.loansService = loansService;
        this.apiConfig = apiConfig;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(
            @RequestParam
            @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
            String mobileNumber)
    {
        loansService.createLoan(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        new ResponseDto(
                                LoansConstants.STATUS_201,
                                LoansConstants.MESSAGE_201
                        )
                );
    }

    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoan(
            @RequestParam
            @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
            String mobileNumber)
    {
        LoansDto loansDto = loansService.fetchLoan(mobileNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loansDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoan(@Valid @RequestBody LoansDto loansDto) {
        boolean isUpdated = loansService.updateLoan(loansDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoan(@RequestParam
        @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
        String mobileNumber)
    {
        boolean isDeleted = loansService.deleteLoan(mobileNumber);

        if (isDeleted)
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(
                            new ResponseDto(
                                    LoansConstants.STATUS_200,
                                    LoansConstants.MESSAGE_200
                            )
                    );
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_DELETE));
        }
    }

    @GetMapping("/version")
    public ResponseEntity<Map<String, String>> buildVersion()
    {
        String version = this.apiConfig.getVersion();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        Map.of("version", version)
                );
    }
}
