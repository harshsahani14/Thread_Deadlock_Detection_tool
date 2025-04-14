package com.harsh.DDT.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RemoteServer {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 private String name;
	 private String ipAddress;
	 private int port;
	 private String protocol; // JMX, SSH, API
	 private boolean isActive;
}
