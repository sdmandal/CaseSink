package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class ErrorPayload {
  String payLoad;
  String exceptionfqcn;
  String exceptionmessage;
  String exceptionstacktrace;
}
