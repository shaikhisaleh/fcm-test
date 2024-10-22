/*
 * Author: Saleh Alshaikhi
 */

package com.alsahab.notification.controller;

import com.alsahab.notification.service.NotificationService;
import com.google.firebase.messaging.FirebaseMessagingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
@AllArgsConstructor
public class NotificationController {

    final private NotificationService notificationService;

    @PostMapping("/message")
    public ResponseEntity<String> sendMessage(
            @RequestParam String key,
            @RequestParam String value,
            @RequestParam String userToken
            ) throws FirebaseMessagingException {

        return ResponseEntity.ok(notificationService.sendMessage(key, value, userToken));
    }

    @PostMapping("/notification")
    public ResponseEntity<String> sendNotification(
            @RequestParam String title,
            @RequestParam String body,
            @RequestParam(required = false) String image,
            @RequestParam String userToken
    ) throws FirebaseMessagingException {

        return ResponseEntity.ok(notificationService.sendNotification(title, body, image, userToken));
    }

}
