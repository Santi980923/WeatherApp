package com.sespitia.weatherapp.service;

import com.sespitia.weatherapp.entity.OperationRegister;
import com.sespitia.weatherapp.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuditService {

    private final AuditRepository auditRepository;

    @Autowired
    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public void saveOperationRegister(String usuario, String operacion, String respuesta){
        OperationRegister operationRegister = new OperationRegister();
        operationRegister.setUsuario(usuario);
        operationRegister.setOperacion(operacion);
        operationRegister.setRespuesta(respuesta);
        operationRegister.setTimeStamp(new Date());
        auditRepository.save(operationRegister);
    }
}
