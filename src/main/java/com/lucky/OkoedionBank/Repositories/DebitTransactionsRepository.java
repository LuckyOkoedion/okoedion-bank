package com.lucky.OkoedionBank.Repositories;

import com.lucky.OkoedionBank.Entities.DebitTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitTransactionsRepository extends JpaRepository<DebitTransactions, Long>
{
}
