package com.logtask.jumiapay.Services;

import com.logtask.jumiapay.model.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Component
public class Customer extends UserAction {



    @Override
    public void addAudit(Audit audit) {
        this.auditRepository.save(audit);
    }

    @Override
    public List<Audit> getUserActivityLog(String email) {
        return this.auditRepository.findByEmailAndType(email, "customer");
    }

    @Override
    public List<Audit> getActivityLog() {
        return this.auditRepository.findByType("customer");
    }

    @Override
    public List<Audit> getActivityLogByDateInterval(Date startDate, Date endDate, int offset, int limit)  {
        Query query = new Query();
        query.addCriteria(Criteria.where("startDate").gte(startDate).lt(endDate));
        query.skip(offset * limit);
        query.limit(limit);

        return this.mongoOpt.find(query, Audit.class);
    }
}
