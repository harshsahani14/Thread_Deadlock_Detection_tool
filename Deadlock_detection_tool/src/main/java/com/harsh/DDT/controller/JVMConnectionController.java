package com.harsh.DDT.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.DDT.service.JVMConnectionService;

@RestController
@RequestMapping("jvm")
public class JVMConnectionController {
	
	@Autowired
	JVMConnectionService service;
	
	@PostMapping("connect")
	public ResponseEntity<String> connectWithJVM(@RequestBody Long server_id){
		return service.connect(server_id);
	}
	
	@DeleteMapping("disconnect")
	public ResponseEntity<String> disconnectWithJVM(@RequestBody Long server_id) throws IOException{
		return service.disconnect(server_id);
	}
	
}
