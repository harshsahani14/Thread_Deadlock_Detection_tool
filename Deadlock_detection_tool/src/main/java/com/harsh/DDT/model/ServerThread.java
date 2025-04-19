package com.harsh.DDT.model;

import java.util.List;

import com.harsh.DDT.model.enums.ThreadStates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ServerThread {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id; 
	 
	 public ServerThread( long threadId, String threadName, ThreadStates threadState, 
			StackTraceElement[] stackTrace, String lockName, String lockOwnerName, long lockOwnerId, long serverId) {
		this.threadId = threadId;
		this.threadName = threadName;
		this.threadState = threadState;
//		this.isDeadlocked = isDeadlocked;
		this.stackTrace = stackTrace;
		this.lockName = lockName;
		this.lockOwnerName = lockOwnerName;
		this.lockOwnerId = lockOwnerId;
		this.serverId = serverId;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public long getThreadId() {
		return threadId;
	}


	public void setThreadId(long threadId) {
		this.threadId = threadId;
	}


	public String getThreadName() {
		return threadName;
	}


	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}


	public ThreadStates getThreadState() {
		return threadState;
	}


	public void setThreadState(ThreadStates threadState) {
		this.threadState = threadState;
	}


	public boolean isDeadlocked() {
		return isDeadlocked;
	}


	public void setDeadlocked(boolean isDeadlocked) {
		this.isDeadlocked = isDeadlocked;
	}


	public StackTraceElement[] getStackTrace() {
		return stackTrace;
	}


	public void setStackTrace(StackTraceElement[] stackTrace) {
		this.stackTrace = stackTrace;
	}


	public String getLockName() {
		return lockName;
	}


	public void setLockName(String lockName) {
		this.lockName = lockName;
	}


	public String getLockOwnerName() {
		return lockOwnerName;
	}


	public void setLockOwnerName(String lockOwnerName) {
		this.lockOwnerName = lockOwnerName;
	}


	public long getLockOwnerId() {
		return lockOwnerId;
	}


	public void setLockOwnerId(long lockOwnerId) {
		this.lockOwnerId = lockOwnerId;
	}


	public Long getServerId() {
		return serverId;
	}


	public void setServerId(Long serverId) {
		this.serverId = serverId;
	}


	private long threadId;
	 private String threadName;
	 private ThreadStates threadState;
	 private boolean isDeadlocked;
	 private StackTraceElement[] stackTrace;
	 private String lockName;
	 private String lockOwnerName;
	 private long lockOwnerId;
	 
	 
	 @ManyToOne
	 private Long serverId;
}
