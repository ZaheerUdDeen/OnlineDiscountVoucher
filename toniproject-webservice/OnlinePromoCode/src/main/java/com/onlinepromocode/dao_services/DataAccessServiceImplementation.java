package com.onlinepromocode.dao_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataAccessServiceImplementation implements DataAccessService{
	@Autowired
	public  FormRespository formRepository;
	
	@Autowired
	public  CustomerRepository customerRepository;
	
	@Autowired
	public  RequesterRespository requestRepository;
	
	@Autowired
	public AdminRepository adminRepository;
}
