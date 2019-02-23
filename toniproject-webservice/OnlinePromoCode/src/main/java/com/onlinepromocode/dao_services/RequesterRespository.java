package com.onlinepromocode.dao_services;

import org.springframework.data.repository.CrudRepository;

import com.onlinepromocode.entities.Admin;
import com.onlinepromocode.entities.Form;
import com.onlinepromocode.entities.Requester;

public interface RequesterRespository extends CrudRepository<Requester,Long>{
	
	public Requester getRequesterByEmailAddress(String email);
}
