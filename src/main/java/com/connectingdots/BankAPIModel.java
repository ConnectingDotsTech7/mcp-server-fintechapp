package com.connectingdots;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAPIModel {

    private String endpoint;
    private String author;
    private String method;
    private String description;
    private String createdOn;
    private String errorMessage;
}
