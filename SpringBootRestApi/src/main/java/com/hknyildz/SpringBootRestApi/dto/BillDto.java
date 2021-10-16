package com.hknyildz.SpringBootRestApi.dto;

import lombok.Data;

@Data
public class BillDto {

    private Integer amount;
    private String productName;
    private String firstName;
    private String lastName;
    private String email;
    private String bill_no;
}
