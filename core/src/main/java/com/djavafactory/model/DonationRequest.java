package com.djavafactory.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.search.annotations.IndexedEmbedded;

@Entity
@Table(name = "donation_request")
@XmlAccessorType(XmlAccessType.NONE)
public class DonationRequest extends BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6174622544839755386L;
	private Long id;
	@XmlElement
	private Date registeredDate;
	@XmlElement
	private Date expiredDate;
	@XmlElement
	private Address address = new Address();
	private Long userId; 
	private User user;

	private List<DonationItem> donationItems = new ArrayList<DonationItem>();
	
	
	public DonationRequest() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlTransient
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

	@Column(name = "userId")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Transient
	public List<DonationItem> getDonationItems() {
		return donationItems;
	}

	public void setDonationItems(List<DonationItem> donationItems) {
		this.donationItems = donationItems;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DonationRequest that = (DonationRequest) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (registeredDate != null ? !registeredDate.equals(that.registeredDate) : that.registeredDate != null)
            return false;
        if (expiredDate != null ? !expiredDate.equals(that.expiredDate) : that.expiredDate != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return !(donationItems != null ? !donationItems.equals(that.donationItems) : that.donationItems != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (registeredDate != null ? registeredDate.hashCode() : 0);
        result = 31 * result + (expiredDate != null ? expiredDate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (donationItems != null ? donationItems.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DonationRequest{" +
                "id=" + id +
                ", registeredDate=" + registeredDate +
                ", expiredDate=" + expiredDate +
                ", address=" + address +
                ", userId=" + userId +
                ", user=" + user +
                ", donationItems=" + donationItems +
                '}';
    }
}
