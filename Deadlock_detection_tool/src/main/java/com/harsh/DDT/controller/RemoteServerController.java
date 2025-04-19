package com.harsh.DDT.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.DDT.dao.RemoteServerRepository;
import com.harsh.DDT.model.RemoteServer;
import com.harsh.DDT.model.ServerThread;
import com.harsh.DDT.service.DeadlockDetectionService;

@RestController
@RequestMapping("servers")
public class RemoteServerController {
    
    @Autowired
    private RemoteServerRepository repo;
    
    @Autowired
    private DeadlockDetectionService service;

    @PostMapping("addServer")
    public RemoteServer addServer(@RequestBody RemoteServer server) {
        return repo.save(server);
    }

    @GetMapping("getAllServers")
    public List<RemoteServer> getAll() {
        return repo.findAll();
    }
    
    @GetMapping("getServerThreads")
    public List<ServerThread> getServerThreads(@RequestBody int serverId  ){
    	
    	Optional<RemoteServer> server = repo.findById(serverId);
    	
    	return service.getServerThreads(server.get());
    }
}