package com.harsh.DDT.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harsh.DDT.model.ServerThread;

@Repository
public interface ServerThreadRepositry extends JpaRepository<ServerThread,Long> {

}
