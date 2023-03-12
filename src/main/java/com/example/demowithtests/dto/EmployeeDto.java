package com.example.demowithtests.dto;

import javax.persistence.Entity;
import java.time.Instant;
import java.util.Date;


public class EmployeeDto {
    public String name;
    public String country;
    public String email;
    public Date creationTime = Date.from(Instant.now());
}
