package com.harsh.DDT.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harsh.DDT.model.RemoteServer;


@Repository
public interface RemoteServerRepository extends JpaRepository<RemoteServer,Long> {

}