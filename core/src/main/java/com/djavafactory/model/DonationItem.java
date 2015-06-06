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

    @Column(name = "qty")
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = true)
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

    @Column(name = "donator_user_id")
    public Long getDonatorUserId() {
        return donatorUserId;
    }

    public void setDonatorUserId(Long donatorUserId) {
        this.donatorUserId = donatorUserId;
    }

    @ManyToOne
    @JoinColumn(name = "donator_user_id", referencedColumnName = "id", insertable = false, updatable = false)
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
}

