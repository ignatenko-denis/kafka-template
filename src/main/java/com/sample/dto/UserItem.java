package com.sample.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserItem {
    private String name;
    private LocalDate birthday;
    private String resume;
}
