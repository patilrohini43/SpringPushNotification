package com.bridgelabz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bridgelabz.model.PushData;
import com.bridgelabz.service.FirebaseMessagingService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;

@Controller
public class PushController {

	@Autowired
	FirebaseMessagingService firebaseService;

	   
	    @RequestMapping("/send-notification")
	    @ResponseBody
	    @PostMapping
	    public String sendNotification(@RequestBody PushData note,
	                                   @RequestParam String token) throws FirebaseMessagingException {
	    	System.out.println("start");
	        return firebaseService.sendNotification(note, token);
	    }
}
