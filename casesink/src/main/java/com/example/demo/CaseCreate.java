package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CaseCreate {
  private int custid;
  private int accountid;
  private String accountNumber;
  private String custNo;
  private String caseNo;
}