package com.irojas.demojwt.repository;

import com.irojas.demojwt.entity.OperationRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<OperationRegister, Integer> {

}
