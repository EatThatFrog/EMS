package org.harshita.ems.api;

import lombok.extern.slf4j.Slf4j;
import org.harshita.ems.model.EmsItem;
import org.harshita.ems.services.EmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    EmsService emsService;

    @GetMapping("/")
    public Map<String, String> home() {
        log.info("HeheHaha!!");
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to Home!");
        return response;
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from AWS Lambda!");
        return response;
    }

    @GetMapping("/ping")
    public Map<String, String> ping() {
        Map<String, String> response = new HashMap<>();
        response.put("pong", "Hello, World!");
        return response;
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<EmsItem> getEmployeeById(@PathVariable String employeeId) {
        try {
            log.info(employeeId);
            EmsItem item = this.emsService.getEmsItems(employeeId);
            log.info(item.toString());
            return ResponseEntity.ok(item);
        } catch (DynamoDbException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}