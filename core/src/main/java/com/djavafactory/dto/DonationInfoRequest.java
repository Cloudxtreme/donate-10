package com.djavafactory.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DonationInfoRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class DonationInfoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6198389304578625043L;

	@XmlElement(required=true)
	private Date applicableDate;

	public Date getApplicableDate() {
		return applicableDate;
	}
	public void setApplicableDate(Date applicableDate) {
		this.applicableDate = applicableDate;
	}
	
	
}
