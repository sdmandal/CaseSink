package com.example.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface EventLogSink {
  String APPLICATIONS_IN = "LENDING_UK_ACCOUNT_LOANS_PAYMENTMISS";
  String APPLICATIONS_IN2 = "BFA_UK_COLLECTIONS_CASE_CREATE";
  String APPLICATIONS_IN3 = "BFA_UK_COLLECTIONS_CASESTRATEGY_ASSESED";
  String APPLICATIONS_IN4 = "BFA_UK_COLLECTIONS_CONTACTSTRATEGY_CONTACTDECIDED";
  String APPLICATIONS_IN5="BARCLAYSCARD_UK_COLLECTIONS_CONTACTDECIDEDCOMMAND";
  String APPLICATIONS_IN6="BFA_UK_COLLECTIONS_ERROR";

  @Input(APPLICATIONS_IN)
  SubscribableChannel sourceOfLoanApplications();
  @Input(APPLICATIONS_IN2)
  SubscribableChannel sourceOfLoanApplications2();

  @Input(APPLICATIONS_IN3)
  SubscribableChannel sourceOfLoanApplications3();

  @Input(APPLICATIONS_IN4)
  SubscribableChannel sourceOfLoanApplications4();

  @Input(APPLICATIONS_IN5)
  SubscribableChannel sourceOfLoanApplications5();

  @Input(APPLICATIONS_IN6)
  SubscribableChannel sourceOfLoanApplications6();

}

