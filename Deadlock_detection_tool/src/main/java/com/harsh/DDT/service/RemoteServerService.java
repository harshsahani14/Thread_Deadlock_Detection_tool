package com.harsh.DDT.service;

import java.util.HashMap;
import java.util.Map;

import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.harsh.DDT.dao.RemoteServerRepository;
import com.harsh.DDT.model.RemoteServer;

@Service
public class RemoteServerService {

	@Autowired
	RemoteServerRepository repo;
	
	
	public ResponseEntity<String> validateCredentials(RemoteServer server){
		
		String url = String.format("service:jmx:rmi:///jndi/rmi://%s:%s/jmxrmi", server.getIpAddress(), server.getPort());

		Map<String, Object> env = new HashMap<>();
		String[] credentials = new String[] { server.getUsername(), server.getPassword() };
		env.put(JMXConnector.CREDENTIALS, credentials);
		
		
		try {
			JMXServiceURL serviceUrl = new JMXServiceURL(url);
		    JMXConnector connector = JMXConnectorFactory.connect(serviceUrl, env);
		    connector.close();
		    
		    repo.save(server);
		    return new ResponseEntity<>("Server added succesfully",HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Invalid server credentials",HttpStatus.BAD_GATEWAY);
		}
	}
	
	public ResponseEntity<String> deleteServerById(Long server_id){
		
		try {
			repo.deleteById(server_id);
			return new ResponseEntity<>("Server deleted sucessfully",HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Could not delete server",HttpStatus.BAD_REQUEST);
		}
	}
}
