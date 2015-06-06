package com.djavafactory.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by toni on 6/6/15.
 */
@Entity
@Table(name = "donation_item")
public class DonationItem {
    private Long id;
    private String itemDescription;
    private Integer qty;
    private ItemCategory category;
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DonationItem donation = (DonationItem) o;

        return id.equals(donation.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

