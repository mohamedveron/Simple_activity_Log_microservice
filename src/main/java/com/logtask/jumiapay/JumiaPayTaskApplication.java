package com.logtask.jumiapay;

import com.logtask.jumiapay.DAL.AuditRepository;
import com.logtask.jumiapay.model.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class JumiaPayTaskApplication{


    public static void main(String[] args) {
        SpringApplication.run(JumiaPayTaskApplication.class, args);
    }


}
