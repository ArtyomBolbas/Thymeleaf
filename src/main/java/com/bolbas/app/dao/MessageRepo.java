package com.bolbas.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolbas.app.model.Message;

public interface MessageRepo extends CrudRepository<Message, Long> {

}
