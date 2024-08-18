package com.egypay.egypay.Controller;

import com.egypay.egypay.Models.DTO.BankDTOBalance;
import com.egypay.egypay.Models.DTO.responseDto;
import com.egypay.egypay.Models.GeneralResponse;
import com.egypay.egypay.Services.UnderBankServiceINT;
import com.egypay.egypay.util.PreperResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UnderBankController {

    private final UnderBankServiceINT UnderbankServiceINT;



    @PostMapping("/balance")
    public ResponseEntity<GeneralResponse<BankDTOBalance>> Balance(@RequestHeader("X-Requested-With") String requestId)
    {

        if (UnderbankServiceINT.getBalance(requestId) != null)
        {
            GeneralResponse<BankDTOBalance> response = PreperResponse.preperResponse(UnderbankServiceINT.getBalance(requestId), "OK", "200");
            return ResponseEntity.ok(response);
        }
        else
        {
            GeneralResponse<BankDTOBalance> response = PreperResponse.preperResponse(null, "Unauthorized Access", "401");
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<GeneralResponse<BankDTOBalance>> Deposit(@RequestHeader("X-Requested-With") String requestId , @RequestBody responseDto responseDto)
    {
        String message = UnderbankServiceINT.Withdraw(requestId , responseDto);

        return switch (message)
        {
            case "-1" ->
            {
                GeneralResponse<BankDTOBalance> response = PreperResponse.preperResponse(null, "Bad Request", "405");
                yield ResponseEntity.ok(response);
            }
            case "0" ->
            {
                GeneralResponse<BankDTOBalance> response2 = PreperResponse.preperResponse(null, "OK", "200");
                yield ResponseEntity.ok(response2);
            }
            case "-2" ->
            {
                GeneralResponse<BankDTOBalance> response3 = PreperResponse.preperResponse(null, "Insufficient Funds", "404");
                yield ResponseEntity.ok(response3);
            }
            case "-3" ->
            {
                GeneralResponse<BankDTOBalance> response4 = PreperResponse.preperResponse(null, "Unauthorized Access", "401");
                yield ResponseEntity.ok(response4);
            }
            case "-4" ->
            {
                GeneralResponse<BankDTOBalance> response5 = PreperResponse.preperResponse(null, "Exceeded the Maximum Amount", "403");
                yield ResponseEntity.ok(response5);
            }
            case "-5" ->
            {
                GeneralResponse<BankDTOBalance> response5 = PreperResponse.preperResponse(null, "Invalid Number", "405");
                yield ResponseEntity.ok(response5);
            }
            default -> null;
        };
    }

    @PostMapping("/deposit")
    public ResponseEntity<GeneralResponse<BankDTOBalance>>  Withdraw(@RequestHeader("X-Requested-With") String requestId , @RequestBody responseDto responseDto)
    {
        String message = UnderbankServiceINT.Deposit(requestId , responseDto);

        return switch (message)
        {
            case "-1" ->
            {
                GeneralResponse<BankDTOBalance> response = PreperResponse.preperResponse(null, "Bad Request", "404");
                yield ResponseEntity.ok(response);
            }
            case "0" ->
            {
                GeneralResponse<BankDTOBalance> response2 = PreperResponse.preperResponse(null, "OK", "200");
                yield ResponseEntity.ok(response2);
            }
            case "-2" ->
            {
                GeneralResponse<BankDTOBalance> response3 = PreperResponse.preperResponse(null, "Minimum Required Deposit 100000.0", "403");
                yield ResponseEntity.ok(response3);
            }
            case "-3" ->
            {
                GeneralResponse<BankDTOBalance> response4 = PreperResponse.preperResponse(null, "Unauthorized Access", "401");
                yield ResponseEntity.ok(response4);
            }
            default -> null;
        };
    }
}

