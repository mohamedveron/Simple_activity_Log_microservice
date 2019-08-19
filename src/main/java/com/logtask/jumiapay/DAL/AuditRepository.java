package com.logtask.jumiapay.DAL;

import com.logtask.jumiapay.model.Audit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuditRepository extends MongoRepository<Audit, String> {

    public List<Audit> findByType(String type);
    public List<Audit> findByEmailAndType(String email, String type);
}
