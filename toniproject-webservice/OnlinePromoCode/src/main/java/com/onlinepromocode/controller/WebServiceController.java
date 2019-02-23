package com.onlinepromocode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepromocode.dao_services.DataAccessServiceImplementation;
import com.onlinepromocode.entities.Admin;
import com.onlinepromocode.entities.Customer;
import com.onlinepromocode.entities.Form;
import com.onlinepromocode.entities.Requester;
import com.onlinepromocode.mailservice.MaiService;
import com.onlinepromocode.responses.FormWrapper;
import com.onlinepromocode.responses.Response;


/**
 * @author Zephyr 
 * Zaheeru7@gmail.com
 */
@RestController
public class WebServiceController {
	MaiService mailService=new MaiService();
	@Autowired
	DataAccessServiceImplementation dataAccessService;
	Response response;

	
	@RequestMapping("/getForm")
	public 	List<Form> getForm() {
		return (List<Form>) dataAccessService.formRepository.findAll();
	}

	@RequestMapping("/getCustomer")
	public 	Customer getCustomer() {
		return new Customer();
	}
	
	@RequestMapping(value ="/addAdmin" , method = RequestMethod.POST)
	public 	Response addAdmin(@RequestBody Admin admin) {
		dataAccessService.adminRepository.save(admin);
		response=new Response();
		response.setResponseCode("00");
		response.setResponseMessage("Form Successfully Submmited");
		
		return response;
	
	}
	
	@RequestMapping(value ="/addRequester" , method = RequestMethod.POST)
	public 	Response getRequester(@RequestBody Requester requester) {
		dataAccessService.requestRepository.save(requester);
		response=new Response();
		response.setResponseCode("00");
		response.setResponseMessage("Form Successfully Submmited");
		
		return response;
	
	}
	@RequestMapping(value ="/submitForm", method = RequestMethod.POST)
	public 	Response submitForm(@RequestBody Form form) {
		System.out.println("requester email :"+form.getRequester().getEmailAddress());
		dataAccessService.requestRepository.save(form.getRequester());
		response=new Response();
		
		form.setAprovalStatus("PENDING");
		dataAccessService.formRepository.save(form);
		
		mailService.doTheEmail(form.getSendTo(), "Online Voucher PromoCode Request", form.toString());
		
		response.setResponseCode("00");
		response.setResponseMessage("Form Successfully Submmited");
		
		return response;
	}
	
	
	@RequestMapping(value ="/resubmitForm/{formid}")
	public 	Response resubmitForm(@PathVariable("formid") Integer formid) {
		Form form=dataAccessService.formRepository.getFormById(formid);
		response=new Response();
		
		form.setAprovalStatus("PENDING");
		
		dataAccessService.formRepository.save(form);
		
		mailService.doTheEmail(form.getSendTo(), "Online Voucher PromoCode Request Resubmitted", form.toString());
		
		response.setResponseCode("00");
		response.setResponseMessage("Form Successfully Submmited");
		
		return response;
	}
	
	@RequestMapping("/viewForm/{requesterEmailAddress}")
	public 	FormWrapper viewForm(@PathVariable("requesterEmailAddress") String requesterEmailAddress) {
		FormWrapper formWrapper=new FormWrapper();
		List<Form> forms=dataAccessService.formRepository.getAllFormByRequesterEmailAddress(requesterEmailAddress);

		formWrapper.setResponseCode("01");
		formWrapper.setResponseMessage("No  form exist");
		if(forms!=null) {
			formWrapper.setForm(forms);
			formWrapper.setResponseCode("00");
			formWrapper.setResponseMessage("All forms");
		}
		
		return formWrapper;
	}
	
	@RequestMapping("/loginRequester/{emailAddress}/{password}")
	public 	Response loginRequester(@PathVariable("emailAddress") String emailAddress,@PathVariable("password") String password) {
		response=new Response();
		Requester requester=dataAccessService.requestRepository.getRequesterByEmailAddress(emailAddress);
		response.setResponseCode("01");
		response.setResponseMessage("Unauthorized access");
		if(requester!=null && requester.getPassword().equalsIgnoreCase(password)) {
			response.setResponseCode("00");
			response.setResponseMessage("Authorized access");
		}
		
		return response;
	}
	@RequestMapping("/loginAdmin/{emailAddress}/{password}")
	public 	Response loginAdmin(@PathVariable("emailAddress") String emailAddress,@PathVariable("password") String password) {
		response=new Response();
		Admin admin=dataAccessService.adminRepository.getAdminByEmailAddress(emailAddress);
		response.setResponseCode("01");
		response.setResponseMessage("Unauthorized access");
		if(admin!=null && admin.getPassword().equalsIgnoreCase(password)) {
			response.setResponseCode("00");
			response.setResponseMessage("Authorized access");
		}
		
		return response;
	}
	
	
	@RequestMapping("/aproveRequest/{formid}/{aprovalStatus}")
	public 	Response aproveRequest(@PathVariable("formid") Integer formid,@PathVariable("aprovalStatus") String aprovalStatus) {
		response=new Response();

		Form form=dataAccessService.formRepository.getFormById(formid);
		form.setAprovalStatus(aprovalStatus);
		dataAccessService.formRepository.save(form);
		
		mailService.doTheEmail(form.getRequester().getEmailAddress(), "Online Voucher PromoCode Status Updated", form.toString());
		response.setResponseCode("00");
		response.setResponseMessage("Authorized access");
		return response;
	}

}
