package com.harsh.DDT.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harsh.DDT.model.DeadlockDetails;

@Repository
public interface DeadLockDetailsRepositry extends JpaRepository<DeadlockDetails,Long> {

}
