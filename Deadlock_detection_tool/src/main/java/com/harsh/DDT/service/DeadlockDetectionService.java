package com.harsh.DDT.service;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import com.harsh.DDT.model.enums.ThreadStates;

import org.springframework.stereotype.Service;

import com.harsh.DDT.model.RemoteServer;
import com.harsh.DDT.model.ServerThread;

@Service
public class DeadlockDetectionService {
	
	public boolean checkDeadlock(RemoteServer server) {
        
        return false;
    }
	
	public boolean checkDeadlockViaJMX(RemoteServer server) {
		
	    return false; // Placeholder
	}
	
	public List<ServerThread> getServerThreads(RemoteServer server){
		
		List<ServerThread> threadInfoList = new ArrayList<>();
		JMXConnector jmxConnector = null;
		
		try {
			
			String url = String.format("service:jmx:rmi:///jndi/rmi://%s:%d/jmxrmi", server.getIpAddress(), server.getPort());
			
			// Connect to the remote JMX server
			JMXServiceURL serviceURL = new JMXServiceURL(url);
			jmxConnector = JMXConnectorFactory.connect(serviceURL, null);
			MBeanServerConnection mbeanConn = jmxConnector.getMBeanServerConnection();
			
			 // Get ThreadMXBean
	        ThreadMXBean threadMXBean = ManagementFactory.newPlatformMXBeanProxy(
	                mbeanConn,
	                ManagementFactory.THREAD_MXBEAN_NAME,
	                ThreadMXBean.class
	        );
	        
	        long[] threadIds = threadMXBean.getAllThreadIds();

            // Get full info (with full stack trace)
            ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(threadIds, Integer.MAX_VALUE);
	        
	        
	        for (ThreadInfo thread : threadInfo) {
                if (thread != null) {
                	
                	Thread.State javaState = thread.getThreadState();
                	ThreadStates customState = ThreadStates.valueOf(javaState.name());
                	
                    ServerThread serverThread = new ServerThread( thread.getThreadId(), thread.getThreadName(),customState
                    		, thread.getStackTrace(),thread.getLockName(),thread.getLockOwnerName(),thread.getLockOwnerId(),server.getId());
                    
                    threadInfoList.add(serverThread);
                }
            }
	        
	        
	        
	        
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			
			if( jmxConnector!=null ) {
				 
				try {
					jmxConnector.close();
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
		}
		
		return threadInfoList;
	}
}
