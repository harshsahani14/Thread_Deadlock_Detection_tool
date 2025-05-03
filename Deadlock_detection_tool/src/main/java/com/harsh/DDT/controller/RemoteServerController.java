package com.harsh.DDT.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.DDT.dao.RemoteServerRepository;
import com.harsh.DDT.model.RemoteServer;
import com.harsh.DDT.model.ServerThread;
// import com.harsh.DDT.service.DeadlockDetectionService;
import com.harsh.DDT.service.RemoteServerService;

@RestController
@RequestMapping("server")
public class RemoteServerController {
    
    @Autowired
    private RemoteServerRepository repo;
    
    @Autowired
    RemoteServerService service;

    @PostMapping("addServer")
    public ResponseEntity<String> addServer(@RequestBody RemoteServer server) {
    	return service.validateCredentials(server);
    }

    @GetMapping("getAllServers")
    public List<RemoteServer> getAll() {
        return repo.findAll();
    }
    
    @DeleteMapping("deleteServer")
    public ResponseEntity<String> deleteServer(Long server_id) {
    	
    	return service.deleteServerById(server_id); 
    }
    
    @GetMapping("getServer")
    public ResponseEntity<RemoteServer> getServer(Long server_id) {
    	
    	Optional<RemoteServer> server =repo.findById(server_id);
    	return new ResponseEntity<>(server.get(),HttpStatus.OK);
    			
    }
    
    
    
    
}