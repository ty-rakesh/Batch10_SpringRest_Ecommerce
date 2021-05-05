package com.te.commercerest.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("response")
@XmlRootElement(name="response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminResponse {
	@JsonProperty("status")
	@XmlElement(name = "status-code")
	private int statusCode;
	
	
	private String  msg;
	
	@JsonProperty("admin")
	@XmlElement(name = "admin")
	private ItemBean bean;
	private List<ItemBean> infoBean;

}