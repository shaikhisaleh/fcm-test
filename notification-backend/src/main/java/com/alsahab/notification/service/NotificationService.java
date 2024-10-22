/*
 * Author: Saleh Alshaikhi
 */

package com.alsahab.notification.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    public String sendMessage(String key, String value, String registrationToken) throws FirebaseMessagingException {
        Message message = Message.builder()
                .putData(key, value)
                .setToken(registrationToken)
                .build();

        return FirebaseMessaging.getInstance().send(message);
    }

    public String sendNotification(String title, String body, String image, String userToken) throws FirebaseMessagingException {
        Message notification;
        if(image != null){
            notification = Message.builder()
                    .setNotification(Notification.builder()
                            .setTitle(title)
                            .setBody(body)
                            .setImage(image)
                            .build())
                    .setToken(userToken)
                    .build();
        }
        else{
            notification = Message.builder()
                    .setNotification(Notification.builder()
                            .setTitle(title)
                            .setBody(body)
                            .build())
                    .setToken(userToken)
                    .build();
        }
        return FirebaseMessaging.getInstance().send(notification);
    }

}
