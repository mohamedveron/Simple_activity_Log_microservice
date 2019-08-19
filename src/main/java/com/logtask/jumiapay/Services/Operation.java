package com.logtask.jumiapay.Services;

import com.logtask.jumiapay.model.Audit;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Component
public class Operation extends UserAction {
    @Override
    public void addAudit(Audit audit) {
        this.auditRepository.save(audit);
    }

    @Override
    public List<Audit> getUserActivityLog(String email) {
        return this.auditRepository.findByEmailAndType(email, "operation");
    }

    @Override
    public List<Audit> getActivityLog() {
        return this.auditRepository.findByType("operation");
    }

    @Override
    public List<Audit> getActivityLogByDateInterval(Date startDate, Date endDate, int offset, int limit)  {
        Query query = new Query();
        query.addCriteria(Criteria.where("startDate").gte(startDate).lt(endDate));

        return this.mongoOpt.find(query, Audit.class);
    }
}
