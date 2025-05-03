package com.harsh.DDT.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DeadlockDetails {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long deadLockId;
	private Long server_id;
	private boolean isDeadLocked;
	private List<ServerThread> deadLockThreads;
	private String timeStamp;
	
	public Long getDeadLockId() {
		return deadLockId;
	}
	public void setDeadLockId(Long deadLockId) {
		this.deadLockId = deadLockId;
	}
	public Long getServer_id() {
		return server_id;
	}
	public void setServer_id(Long server_id) {
		this.server_id = server_id;
	}
	public boolean isDeadLocked() {
		return isDeadLocked;
	}
	public void setDeadLocked(boolean isDeadLocked) {
		this.isDeadLocked = isDeadLocked;
	}
	public List<ServerThread> getDeadLockThread() {
		return deadLockThreads;
	}
	public void setDeadLockThread(List<ServerThread> deadLockThread) {
		this.deadLockThreads = deadLockThread;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public DeadlockDetails(Long deadLockId, Long server_id, boolean isDeadLocked, List<ServerThread> deadLockThread,
			String timeStamp) {
		super();
		this.deadLockId = deadLockId;
		this.server_id = server_id;
		this.isDeadLocked = isDeadLocked;
		this.deadLockThreads = deadLockThread;
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "DeadlockDetails [deadLockId=" + deadLockId + ", server_id=" + server_id + ", isDeadLocked="
				+ isDeadLocked + ", deadLockThread=" + deadLockThreads + ", timeStamp=" + timeStamp + "]";
	}
	

}
