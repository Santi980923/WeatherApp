package com.sespitia.weatherapp.repository;

import com.sespitia.weatherapp.entity.OperationRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<OperationRegister, Integer> {

}
