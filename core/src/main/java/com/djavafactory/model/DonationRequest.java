package com.djavafactory.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.search.annotations.IndexedEmbedded;

@Entity
@Table(name = "donation_request")
public class DonationRequest extends BaseObject implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6174622544839755386L;
	private Long id;
	private Date registeredDate;
	private Date expiredDate;
	private Address address = new Address();
	private Long userId;
	private String donationItem;
	private Integer donationQty;

	private Set<DonationItem> donationItems = new HashSet<DonationItem>();
	
	public DonationRequest() {
		super();
	}


	@OneToMany(cascade = CascadeType.ALL, mappedBy="donationRequest")
	public Set<DonationItem> getDonationItems() {
		return donationItems;
	}

	public void setDonationItems(Set<DonationItem> donationItems) {
		this.donationItems = donationItems;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	@Embedded
    @IndexedEmbedded
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "donation_item")
	public String getDonationItem() {
		return donationItem;
	}

	public void setDonationItem(String donationItem) {
		this.donationItem = donationItem;
	}

	@Column(name = "donation_qty")
	public Integer getDonationQty() {
		return donationQty;
	}

	public void setDonationQty(Integer donationQty) {
		this.donationQty = donationQty;
	}

	@Override
	public String toString() {
		return "DonationRequest [id=" + id + ", registeredDate="
				+ registeredDate + ", expiredDate=" + expiredDate
				+ ", address=" + address + ", userId=" + userId + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonationRequest other = (DonationRequest) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (expiredDate == null) {
			if (other.expiredDate != null)
				return false;
		} else if (!expiredDate.equals(other.expiredDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (registeredDate == null) {
			if (other.registeredDate != null)
				return false;
		} else if (!registeredDate.equals(other.registeredDate))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((expiredDate == null) ? 0 : expiredDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((registeredDate == null) ? 0 : registeredDate.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
