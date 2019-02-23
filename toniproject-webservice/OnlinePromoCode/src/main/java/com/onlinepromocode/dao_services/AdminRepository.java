package com.onlinepromocode.dao_services;

import org.springframework.data.repository.CrudRepository;

import com.onlinepromocode.entities.Admin;
import com.onlinepromocode.entities.Requester;

public interface AdminRepository  extends CrudRepository<Admin,Long>{
 public Admin getAdminByEmailAddress(String email);
}
