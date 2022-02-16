package com.lucky.OkoedionBank.Repositories;

import com.lucky.OkoedionBank.Entities.ActivityLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends JpaRepository<ActivityLogs, Long>
{
}
