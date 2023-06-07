package com.eswagger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/")
public class AppController {


    @GetMapping(value = "/getEmails")
    public ResponseEntity<Object> getEmails() {
        try {
            List<String> emails = new ArrayList<>();
            emails.add("abc@yopmail.com");
            emails.add("efg@yopmail.com");
            emails.add("ijk@yopmail.com");
            emails.add("mno@yopmail.com");
            return new ResponseEntity<>(emails, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error while getting emails :", e);
            return new ResponseEntity<>("Error while getting emails", HttpStatus.BAD_GATEWAY);
        }
    }

}
