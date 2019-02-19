package com.onlinepromocode.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepromocode.entities.Form;

@RestController
public class WebServiceController {

	@RequestMapping("/getForm")
	public 	Form syHI() {
		return new Form();
	}
	
	@RequestMapping(value ="/submitForm", method = RequestMethod.POST)
	public 	void submitForm(@RequestBody Form form) {
		System.out.println(form.getJustification());
	}
}
