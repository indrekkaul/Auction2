package com.example.auction.repositorys;

import com.example.auction.model.TransactionEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionEvaluationRepository extends JpaRepository<TransactionEvaluation, Long> {
}
