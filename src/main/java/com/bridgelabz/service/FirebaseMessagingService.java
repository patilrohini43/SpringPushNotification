package com.bridgelabz.service;


import org.springframework.stereotype.Service;

import com.bridgelabz.model.PushData;
import com.google.firebase.messaging.*;


@Service
public class FirebaseMessagingService {
	
	  private final FirebaseMessaging firebaseMessaging;

	    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
	        this.firebaseMessaging = firebaseMessaging;
	    }


	    public String sendNotification(PushData note, String topic) throws FirebaseMessagingException {

	        Notification notification = Notification
	                .builder()
	                .setTitle(note.getMessage())
	                //.setBody(note.getContent())
	                .setImage(note.getSubmitAnswerLink())
	                .build();

	        Message message = Message
	                .builder()
	                .setToken(topic)
	                .setNotification(notification)
	              //  .putAllData(note.getData())
	                .build();

	        return firebaseMessaging.send(message);
	    }


}
