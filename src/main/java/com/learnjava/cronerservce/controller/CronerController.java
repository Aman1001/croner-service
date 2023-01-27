package com.learnjava.cronerservce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cron-service")
public class CronerController {
    @PostMapping
    public ResponseEntity addCronJob(){
        return null;
    }
    @PutMapping
    public ResponseEntity updateCronJon(){
        return null;
    }
    @GetMapping
    public ResponseEntity getCronJobDetails(){
        return null;
    }
    @DeleteMapping
    public ResponseEntity deleteCronJob(String jobId){
        return null;
    }
}
