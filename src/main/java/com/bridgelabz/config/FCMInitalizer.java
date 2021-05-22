package com.bridgelabz.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;

@Configuration
public class FCMInitalizer {


	
	 @Bean
	    FirebaseMessaging firebaseMessaging() throws IOException {
	        GoogleCredentials googleCredentials = GoogleCredentials
	                .fromStream(new ClassPathResource("google/push1-16180-firebase-adminsdk-g1gyx-b486bf823e.json").getInputStream());
	        FirebaseOptions firebaseOptions = FirebaseOptions
	                .builder()
	                .setCredentials(googleCredentials)
	                .build();
	        FirebaseApp app = FirebaseApp.initializeApp(firebaseOptions, "my-app");
	        return FirebaseMessaging.getInstance(app);
	    }
}
