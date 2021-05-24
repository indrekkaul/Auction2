package com.example.auction.controllers;

import com.example.auction.model.TransactionEvaluation;
import com.example.auction.repositorys.TransactionEvaluationRepository;
import com.example.auction.services.TransactionEvaluationService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionEvaluationController {

    TransactionEvaluationRepository transactionEvaluationRepository;
    TransactionEvaluationService transactionEvaluationService;

    public TransactionEvaluationController(TransactionEvaluationRepository transactionEvaluationRepository
            ,TransactionEvaluationService transactionEvaluationService) {
        this.transactionEvaluationRepository = transactionEvaluationRepository;
        this.transactionEvaluationService = transactionEvaluationService;
    }

    @PutMapping("registerTransaction")
    public String showRegistrationForm(Model model){
        return "register Transaction";
    }

    @GetMapping("/allTransactions")
    List<TransactionEvaluation> getAllTransactions(){
        return transactionEvaluationService.findAll();
    }

    @GetMapping("/singleTransaction")
    public TransactionEvaluation getTransactionEvaluation (TransactionEvaluation transactionEvaluation){
        return transactionEvaluationService.findOne(transactionEvaluation.getId());
    }

}
