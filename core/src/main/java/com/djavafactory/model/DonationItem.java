package com.djavafactory.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

/**
 * Created by toni on 6/6/15.
 */
@Entity
@Table(name = "donation_item")
@XmlAccessorType(XmlAccessType.NONE)
public class DonationItem {
    private Long id;
    @XmlElement
    private String itemDescription;
    @XmlElement
    private Integer qty;
    @XmlElement
    private ItemCategory category;

    private Long donatorUserId;
    private User donatorUser;
    private Date donatedDate;

    private DonationRequest donationRequest;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "description")
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }



    @Column(name = "donator_user_id")
    public Long getDonatorUserId() {
        return donatorUserId;
    }

    public void setDonatorUserId(Long donatorUserId) {
        this.donatorUserId = donatorUserId;
    }

    @Column(name = "donator_user_id")
    public User getDonatorUser() {
        return donatorUser;
    }

    public void setDonatorUser(User donatorUser) {
        this.donatorUser = donatorUser;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getDonatedDate() {
        return donatedDate;
    }

    public void setDonatedDate(Date donatedDate) {
        this.donatedDate = donatedDate;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @ManyToOne
    @JoinColumn(name = "donator_user_id", referencedColumnName = "id", insertable = false, updatable = false)
    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "request_id", nullable = false)
    public DonationRequest getDonationRequest() {
        return donationRequest;
    }

    public void setDonationRequest(DonationRequest donationRequest) {
        this.donationRequest = donationRequest;
    }

    @Override
    public String toString() {
        return "DonationItem{" +
                "id=" + id +
                ", itemDescription='" + itemDescription + '\'' +
                ", qty=" + qty +
                ", category=" + category +
                ", donatorUserId=" + donatorUserId +
                ", donatorUser=" + donatorUser +
                ", donatedDate=" + donatedDate +
                ", donationRequest=" + donationRequest +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DonationItem that = (DonationItem) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (itemDescription != null ? !itemDescription.equals(that.itemDescription) : that.itemDescription != null)
            return false;
        if (qty != null ? !qty.equals(that.qty) : that.qty != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (donatorUserId != null ? !donatorUserId.equals(that.donatorUserId) : that.donatorUserId != null)
            return false;
        if (donatorUser != null ? !donatorUser.equals(that.donatorUser) : that.donatorUser != null) return false;
        if (donatedDate != null ? !donatedDate.equals(that.donatedDate) : that.donatedDate != null) return false;
        return !(donationRequest != null ? !donationRequest.equals(that.donationRequest) : that.donationRequest != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (itemDescription != null ? itemDescription.hashCode() : 0);
        result = 31 * result + (qty != null ? qty.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (donatorUserId != null ? donatorUserId.hashCode() : 0);
        result = 31 * result + (donatorUser != null ? donatorUser.hashCode() : 0);
        result = 31 * result + (donatedDate != null ? donatedDate.hashCode() : 0);
        result = 31 * result + (donationRequest != null ? donationRequest.hashCode() : 0);
        return result;
    }
}

