package com.onlinepromocode.dao_services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.onlinepromocode.entities.Form;

public interface FormRespository extends CrudRepository<Form,Long>{

	public Form getFormByRequesterEmailAddress(String emailAddress);
	public List<Form> getAllFormByRequesterEmailAddress(String emailAddress);
	public Form getFormById(Integer id);
}
