package com;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Driver {
    // Find your Account Sid and Token at twilio.com/console
    // DANGER! This is insecure. See http://twil.io/secure
    public static final String ACCOUNT_SID = System.getenv("SID");
    public static final String AUTH_TOKEN = System.getenv("TOKEN");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber(System.getenv("PHONE")),
                new PhoneNumber("+15873271493"),
                "FIRST MESSAGE")
                .create();

        System.out.println(message.getSid());
    }
}
