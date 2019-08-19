package com.logtask.jumiapay.model;

import java.util.Date;

public class Request {

    public String type;
    public int offset;
    public int limit;
    public String email;
    public String password;
    public Date startDate;
    public Date lastDate;

    public Request(String type, int offset, int limit, String email, String password, Date startDate, Date lastDate) {
        this.type = type;
        this.offset = offset;
        this.limit = limit;
        this.email = email;
        this.password = password;
        this.startDate = startDate;
        this.lastDate = lastDate;
    }
}
