package com.docanalyzer.project.repository;

import com.docanalyzer.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u FROM User u WHERE u.registrationDate < :endDate AND NOT EXISTS "
            + "(SELECT d FROM Document d WHERE d.user = u AND d.uploadDate BETWEEN :startDate AND :endDate)")
    List<User> findInactiveUsers(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
