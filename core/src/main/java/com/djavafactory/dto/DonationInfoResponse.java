package com.djavafactory.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.djavafactory.model.DonationRequest;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class DonationInfoResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3925111948906562720L;

	@XmlElement
	private List<DonationRequest> requestList;

	public List<DonationRequest> getRequestList() {
		return requestList;
	}

	public void setRequestList(List<DonationRequest> requestList) {
		this.requestList = requestList;
	} 

}
