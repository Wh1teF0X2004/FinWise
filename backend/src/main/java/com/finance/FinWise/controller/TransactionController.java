package com.finance.FinWise.controller;

import com.finance.FinWise.model.Transaction;
import com.finance.FinWise.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/user/{userId}")
    public List<Transaction> getTransactionsByUser(@PathVariable Long userId) {
        return transactionService.getTransactionsByUserId(userId);
    }

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @DeleteMapping("/{transId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long transId) {
        transactionService.deleteTransaction(transId);
        return ResponseEntity.ok("Transaction deleted successfully");
    }
}
