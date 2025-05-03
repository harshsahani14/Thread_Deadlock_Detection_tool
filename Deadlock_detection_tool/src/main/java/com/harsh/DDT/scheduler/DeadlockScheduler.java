// package com.harsh.DDT.scheduler;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Component;

// import com.harsh.DDT.dao.RemoteServerRepository;
// import com.harsh.DDT.model.RemoteServer;
// import com.harsh.DDT.service.DeadlockDetectionService;

// @Component
// public class DeadlockScheduler {
	
// 	@Autowired
//     private RemoteServerRepository remoteServerRepository;

//     @Autowired
//     private DeadlockDetectionService deadlockService;

//     // Runs every 30 seconds
//     @Scheduled(fixedRate = 30000)
//     public void checkAllServers() {
//         List<RemoteServer> servers = remoteServerRepository.findAll();

// //        for (RemoteServer server : servers) {
// //            boolean hasDeadlock = deadlockService.checkDeadlockViaJMX(server);
// //            System.out.println("Server: " + server.getName() + " Deadlock Detected: " + hasDeadlock);
// //        }
//     }
// }
