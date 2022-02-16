package com.lucky.OkoedionBank.Repositories;

import com.lucky.OkoedionBank.Entities.BankAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertsRepository extends JpaRepository<BankAlert, Long> {
}
