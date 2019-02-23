package com.onlinepromocode.dao_services;

import org.springframework.data.repository.CrudRepository;

import com.onlinepromocode.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long>{

}
