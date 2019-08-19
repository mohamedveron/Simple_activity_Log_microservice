package com.logtask.jumiapay.model;

import com.bol.secure.Encrypted;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.datetime.joda.DateTimeFormatterFactory;

import java.util.Date;

public class Audit {

    @Id
    public String id;

    public String email;

    @Field
    @Encrypted
    public String password;

    @Field
    @Encrypted
    public String creditCard;

    public Date startDate;
    public Date lastUpdatedDate;
    public String actionDescription;
    public String type;

    public Audit() {}

    public Audit(String email, String password, String creditCard, Date startDate, Date lastUpdatedDate, String actionDescription, String type) {
        this.email = email;
        this.password = password;
        this.creditCard = creditCard;
        this.startDate = startDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.actionDescription = actionDescription;
        this.type = type;
    }

}
