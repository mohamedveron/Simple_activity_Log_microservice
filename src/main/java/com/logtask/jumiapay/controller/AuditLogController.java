package com.logtask.jumiapay.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.logtask.jumiapay.Services.UserAction;
import com.logtask.jumiapay.model.Audit;
import com.logtask.jumiapay.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuditLogController {

    // Object Reflection map ti detect the type of user object in run time
    @Autowired
    Map<String, UserAction> userActionStrategies = new HashMap<String, UserAction>();

    /*
        Get request
        http://localhost:8080/logs/?offset=0&limit=1
     */

    // Retrieves all activity log with pagination
    @RequestMapping(value="/logs/", method = RequestMethod.GET)
    public List<Audit> getAllLog(@RequestParam("offset") int offset, @RequestParam("limit") int limit){

        limit = (limit > 0) ? limit : 1;
        return userActionStrategies.get("customer").getAllActivityLog(offset, limit);
    }

    /*
        Put request
        http://localhost:8080/logs/add

        Body
        {
            "email" : "veron@gmail.com",
            "password": "76885",
            "creditCard": "",
            "startDate": "2019-08-18",
            "lastUpdatedDate": "2019-08-18",
            "actionDescription": "trigger sell issue",
            "type" : "operation"
        }
     */

    // add new activity log object
    @PutMapping("/logs/add")
    public void addLog(@RequestBody Audit newlog) {
        userActionStrategies.get(newlog.type).addAudit(newlog);


    }

    /*
        http://localhost:8080/logs/

        Body
        {
            "type" : "operation",
            "offset" : 0,
            "limit" : 1,
            "email" : "veron@gmail.com"
        }

     */
    // Retrieves all activity log for user type
    @PostMapping("/logs/")
    public List<Audit> activityLog(@RequestBody Request request) {

      return  userActionStrategies.get(request.type).getActivityLog();
    }

    /*
        http://localhost:8080/userLogs/

        Body
        {
            "type" : "operation",
            "offset" : 0,
            "limit" : 1,
            "email" : "veron@gmail.com"
        }

     */
    // Retrieves all activity log for user by email
    @PostMapping("/userLogs/")
    public List<Audit> userActivityLog(@RequestBody Request request) {

        return  userActionStrategies.get(request.type).getUserActivityLog(request.email);
    }


    /*
        http://localhost:8080/userLogsDate/

        Body
        {
            "type" : "customer",
            "offset" : 0,
            "limit" : 3,
            "startDate" : "2019-08-15",
            "lastDate" : "2019-08-19"
        }

     */
    // Retrieves all activity log for user within date range with pagination
    @PostMapping("/userLogsDate/")
    public List<Audit> userActivityLogWithinDateRange(@RequestBody Request request) {

        int limit = (request.limit > 0) ? request.limit : 1;
        return  userActionStrategies.get(request.type).getActivityLogByDateInterval(request.startDate, request.lastDate, request.offset, limit);
    }
}
