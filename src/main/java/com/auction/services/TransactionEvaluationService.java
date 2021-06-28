package com.auction.services;

import com.auction.model.TransactionEvaluation;

import java.util.List;

public interface TransactionEvaluationService {

    TransactionEvaluation findOne(Long id);

    List<TransactionEvaluation> findAll();

    void save (TransactionEvaluation transactionEvaluation);

    void update (Long id, TransactionEvaluation transactionEvaluation);

    void delete (Long id);

    void restore (Long id);

}
