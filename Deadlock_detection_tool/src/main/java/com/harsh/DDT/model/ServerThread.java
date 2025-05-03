package com.harsh.DDT.model;

import java.util.List;

import com.harsh.DDT.model.enums.ThreadStates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ServerThread {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long threadId;
	 private ThreadStates threadState;
	 private List<String> stackTrace;
	 private String holdingLocks;
	 private String waitingOn ;
	 private Long cpuUsage;
	 

	 
	@Override
	public String toString() {
		return "ServerThread [threadId=" + threadId + ", threadState=" + threadState + ", stackTrace=" + stackTrace
				+ ", holdingLocks=" + holdingLocks + ", waitingOn=" + waitingOn + ", cpuUsage=" + cpuUsage ;
	}


	public ServerThread(long threadId, ThreadStates threadState, List<String> stackTrace, String holdingLocks,
			String waitingOn, Long cpuUsage, Long id) {
		super();
		this.threadId = threadId;
		this.threadState = threadState;
		this.stackTrace = stackTrace;
		this.holdingLocks = holdingLocks;
		this.waitingOn = waitingOn;
		this.cpuUsage = cpuUsage;
		
	}



	public long getThreadId() {
		return threadId;
	}


	public void setThreadId(long threadId) {
		this.threadId = threadId;
	}



	public List<String> getStackTrace() {
		return stackTrace;
	}



	public void setStackTrace(List<String> stackTrace) {
		this.stackTrace = stackTrace;
	}



	public String getHoldingLocks() {
		return holdingLocks;
	}



	public void setHoldingLocks(String holdingLocks) {
		this.holdingLocks = holdingLocks;
	}



	public String getWaitingOn() {
		return waitingOn;
	}



	public void setWaitingOn(String waitingOn) {
		this.waitingOn = waitingOn;
	}



	public Long getCpuUsage() {
		return cpuUsage;
	}



	public void setCpuUsage(Long cpuUsage) {
		this.cpuUsage = cpuUsage;
	}



	public ThreadStates getThreadState() {
		return threadState;
	}


	public void setThreadState(ThreadStates threadState) {
		this.threadState = threadState;
	}




	
}
