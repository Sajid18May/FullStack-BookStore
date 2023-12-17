package com.bookstore.amber.dto;

import lombok.Data;

@Data
public class AuthBody {
    private String email;
    private String password;
}
