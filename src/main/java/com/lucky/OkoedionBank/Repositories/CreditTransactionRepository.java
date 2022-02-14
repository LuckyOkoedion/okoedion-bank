package com.lucky.OkoedionBank.Repositories;

import com.lucky.OkoedionBank.Entities.CreditTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditTransactionRepository extends JpaRepository<CreditTransactions, Long>
{
}
