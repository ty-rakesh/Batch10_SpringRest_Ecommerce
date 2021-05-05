package com.te.commercerest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.commercerest.beans.AdminResponse;
import com.te.commercerest.beans.ItemBean;
import com.te.commercerest.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService service;
	
	@GetMapping(path = "/get", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public AdminResponse getItemData(int id) {

		AdminResponse response = new AdminResponse();
		ItemBean infoBean = service.getItemData(id);

		if (infoBean != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setBean(infoBean);
		} else {
			response.setStatusCode(404);
			response.setMsg("Failure , Data Not found");
		}

		return response;
	}// end of getEmpData
	
	
	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public AdminResponse getAllItemDetails() {
		AdminResponse response = new AdminResponse();
		List<ItemBean> infoBeans = service.getAllItemDetails();

		if (infoBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			
		} else {
			response.setStatusCode(400);
			response.setMsg("Datas not found");
		}

		return response;
	}
	
	
	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public AdminResponse addEmpData(@RequestBody ItemBean infoBean) {
		AdminResponse response = new AdminResponse();

		if (service.addItem(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("success , Added the record");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not add the data");
		}

		return response;
	}
	
	@DeleteMapping(path = "/delete/{aId}" , produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public AdminResponse deleteEmpData(@PathVariable(name = "aId")int id ) {
		AdminResponse response = new AdminResponse();

		if (service.deleteItem(id)) {
			response.setStatusCode(200);
			response.setMsg("success , record deleted");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not delete the record");
		}
		return response;
	}

}
