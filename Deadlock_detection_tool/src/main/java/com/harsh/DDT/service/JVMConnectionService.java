package com.harsh.DDT.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
public class JVMConnectionService {

	@Autowired
	RemoteServerRepository repo;
	
	Map<Long,JMXConnector> map = new HashMap<>();
	
	public ResponseEntity<String> connect( Long server_id ){
		
		try {
			
			if (map.containsKey(server_id)) {
                return new ResponseEntity<>("Already connected to server ID: " + server_id,HttpStatus.OK);
            }
			
			Optional<RemoteServer> server = repo.findById(server_id);
				
			if(!server.isPresent()) {
				return new ResponseEntity<>("Server id is invalid",HttpStatus.BAD_REQUEST);
			}
			
			RemoteServer remoteServer = server.get();
			
			String jmxUrl = String.format("service:jmx:rmi:///jndi/rmi://%s:%d/jmxrmi",remoteServer.getIpAddress(),remoteServer.getPort() );
			
	
            Map<String, Object> env = new HashMap<>();
            env.put(JMXConnector.CREDENTIALS, new String[]{remoteServer.getName(), remoteServer.getPassword()});
            JMXServiceURL serviceURL = new JMXServiceURL(jmxUrl);
            JMXConnector connector = JMXConnectorFactory.connect(serviceURL, env);

            
            map.put(server_id, connector);

            return new ResponseEntity<>("Connected to JVM",HttpStatus.OK);
			
		}
		catch(Exception e) {
			return new ResponseEntity<>("Could not connect with JVM",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	public ResponseEntity<String> disconnect(Long server_id) throws IOException  {
        
		try {
			JMXConnector connector = map.remove(server_id);
	        if (connector != null) connector.close();
	        
	        return new ResponseEntity<>("Disconnected with JVM",HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Could not disconnect with JVM",HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	public Map<Long,JMXConnector> getConnectorMap(){
		return  Collections.unmodifiableMap(map);
	}
}
