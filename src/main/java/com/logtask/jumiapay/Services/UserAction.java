package com.logtask.jumiapay.Services;

import com.logtask.jumiapay.DAL.AuditRepository;
import com.logtask.jumiapay.model.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.Date;
import java.util.List;

public abstract class UserAction {

    @Autowired
    protected AuditRepository auditRepository;

    @Autowired
    protected MongoOperations mongoOpt;


    public abstract void addAudit(Audit audit);

    public List<Audit> getAllActivityLog(int offset, int limit){

         Page<Audit> page = auditRepository.findAll( PageRequest.of(offset, limit, Sort.by(Sort.Direction.DESC, "startDate")));

        return page.getContent();
    }

    public abstract List<Audit> getUserActivityLog(String email);

    public abstract List<Audit> getActivityLog();

    public abstract List<Audit> getActivityLogByDateInterval(Date startDate, Date endDate, int offset, int limit);


}
