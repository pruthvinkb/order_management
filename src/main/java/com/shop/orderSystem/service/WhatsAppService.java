/*package com.shop.orderSystem.service;

import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
@Service
public class WhatsAppService {

 @Value("${twilio.account.sid}")
private String accountSid;

@Value("${twilio.auth.token}")
private String authToken;

@Value("${twilio.whatsapp.number}")
private String fromNumber;
  
public void sendMessage(String toNumber,String messageBody){
    Twilio.init(accountSid, authToken);
    Message message = Message.creator(
            new PhoneNumber("whatsapp:" + toNumber),
            new PhoneNumber(fromNumber),
            messageBody
    ).create();
}
}*/
