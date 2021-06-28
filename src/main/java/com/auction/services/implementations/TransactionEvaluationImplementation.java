package com.auction.services.implementations;

import com.auction.model.TransactionEvaluation;
import com.auction.repositorys.TransactionEvaluationRepository;
import com.auction.services.TransactionEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionEvaluationImplementation implements TransactionEvaluationService {

    @Autowired
    TransactionEvaluationRepository transactionEvaluationRepository;

    @Override
    public TransactionEvaluation findOne(Long id) {
        return transactionEvaluationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Transaction Evaluation not found!"));
    }

    @Override
    public List<TransactionEvaluation> findAll() {
        List<TransactionEvaluation> transactionEvaluations = new ArrayList<>
                (transactionEvaluationRepository.findAll());
        return transactionEvaluations;
    }

    @Override
    public void save(TransactionEvaluation transactionEvaluation) {
        transactionEvaluationRepository.saveAndFlush(transactionEvaluation);
    }

    @Override
    public void update(Long id, TransactionEvaluation transactionEvaluation) {
        TransactionEvaluation oldTransactionEvaluation = findOne(transactionEvaluation.getId());
        oldTransactionEvaluation.setBuyerRating(transactionEvaluation.getBuyerRating());
        oldTransactionEvaluation.setPurchase(transactionEvaluation.getPurchase());
        oldTransactionEvaluation.setSellerComment(transactionEvaluation.getSellerComment());
        oldTransactionEvaluation.setSellerRating(transactionEvaluation.getSellerRating());

        save(oldTransactionEvaluation);
    }

    @Override
    public void delete(Long id) {
        TransactionEvaluation transactionEvaluationDelete = findOne(id);
        transactionEvaluationDelete.setActive(false);
        save(transactionEvaluationDelete);
    }

    @Override
    public void restore(Long id) {
        TransactionEvaluation transactionEvaluationRestore = findOne(id);
        transactionEvaluationRestore.setActive(true);
        save(transactionEvaluationRestore);
    }
}
