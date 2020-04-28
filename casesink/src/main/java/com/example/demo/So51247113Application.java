package com.example.demo;

import com.google.gson.Gson;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableBinding(EventLogSink.class)
public class So51247113Application {

  public static void main(String[] args) {
    SpringApplication.run(So51247113Application.class, args);
  }

  @Autowired
  EventLogRepository eventLogRepository;

  @StreamListener(EventLogSink.APPLICATIONS_IN)
  public void SinkCustomer(Customer customer, @Header(KafkaHeaders.CORRELATION_ID) String correlationID) {
    System.out.println("LENDING_UK_ACCOUNT_LOANS_PAYMENTMISS");
    System.out.println(customer);
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    Date date = new Date();
    Eventlog eventlog = new Eventlog(correlationID, UUID.randomUUID().toString(), "LENDING_UK_ACCOUNT_LOANS",
        "PAYMENTMISS", new Gson().toJson(customer), 0);
    eventLogRepository.save(eventlog);
  }

  @StreamListener(EventLogSink.APPLICATIONS_IN2)
  public void SinkCustomer2(CaseCreate customer, @Header(KafkaHeaders.CORRELATION_ID) String correlationID) {
    System.out.println("BFA_UK_COLLECTIONS_CASE_CREATE");
    System.out.println(customer);
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    Date date = new Date();
    Eventlog eventlog = new Eventlog(correlationID, UUID.randomUUID().toString(), "BFA_UK_COLLECTIONS_CASE",
        "CASECREATE", new Gson().toJson(customer), 1);
    eventLogRepository.save(eventlog);
  }

  @StreamListener(EventLogSink.APPLICATIONS_IN3)
  public void SinkCustomer3(CaseStrategy customer, @Header(KafkaHeaders.CORRELATION_ID) String correlationID) {
    System.out.println("BFA_UK_COLLECTIONS_CASESTRATEGY_ASSESED");
    System.out.println(customer);
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    Date date = new Date();
    Eventlog eventlog = new Eventlog(correlationID, UUID.randomUUID().toString(), "BFA_UK_COLLECTIONS_CASESTRATEGY",
        "ASSESED", new Gson().toJson(customer),  2);
    eventLogRepository.save(eventlog);
  }

  @StreamListener(EventLogSink.APPLICATIONS_IN4)
  public void SinkCustomer4(ContactStrategy customer, @Header(KafkaHeaders.CORRELATION_ID) String correlationID) {
    System.out.println("BFA_UK_COLLECTIONS_CONTACTSTRATEGY_CONTACTDECIDED");
    System.out.println(customer);
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    Date date = new Date();
    Eventlog eventlog = new Eventlog(correlationID, UUID.randomUUID().toString(), "BFA_UK_COLLECTIONS_CONTACTSTRATEGY",
        "CONTACTDECIDED", new Gson().toJson(customer), 3);
    eventLogRepository.save(eventlog);
  }

  @StreamListener(EventLogSink.APPLICATIONS_IN5)
  public void SinkCustomer5(CustmerEmailSendStatus customer,
      @Header(KafkaHeaders.CORRELATION_ID) String correlationID) {
    System.out.println("BARCLAYSCARD_UK_COLLECTIONS_CONTACTDECIDEDCOMMAND");
    System.out.println(customer);
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    Date date = new Date();
    Eventlog eventlog = new Eventlog(correlationID, UUID.randomUUID().toString(),
        "BARCLAYSCARD_UK_COLLECTIONS_DECIDEDCOMMAND", "EMAILSENT", new Gson().toJson(customer), 4);
    eventLogRepository.save(eventlog);
  }

  @StreamListener(EventLogSink.APPLICATIONS_IN6)
  public void SinkCustomer6(String customer,@Header(KafkaHeaders.CORRELATION_ID) String correlationID,MessageHeaders headers)

	{

   	ErrorPayload errorPayload=new ErrorPayload();
		errorPayload.setPayLoad(customer);
		errorPayload.setExceptionfqcn(getByteString(headers,"x-exception-fqcn"));
		errorPayload.setExceptionmessage(getByteString(headers,"x-exception-message"));
		errorPayload.setExceptionstacktrace(getByteString(headers,"x-exception-stacktrace"));
		System.out.println("BFA_UK_COLLECTIONS_ERROR"+headers.toString());
    System.out.println(customer);
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    Date date = new Date();
    Eventlog eventlog = new Eventlog(correlationID, UUID.randomUUID().toString(), "BFA_UK_COLLECTIONS_ERROR",
        "EXCEPTION", new Gson().toJson(errorPayload), 4);
    eventLogRepository.save(eventlog);
  }

  private String getByteString(MessageHeaders headers,String headerKey) {
    if(headers.get(headerKey)!=null) {
      byte[] bytes = (byte[]) headers.get(headerKey);
      return new String(bytes);
    }
  else
    return null;
  }


  @KafkaListener(id = "foo", topics = "dead-out")
  public void dlq(Message<?> in) {
    System.out.println("DLQ:" + in);
  }

}