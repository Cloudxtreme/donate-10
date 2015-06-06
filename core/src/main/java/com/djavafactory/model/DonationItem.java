package com.djavafactory.model;

import javax.persistence.*;

/**
 * Created by toni on 6/6/15.
 */
@Entity
@Table(name = "DONATION")
public class DonationItem {
    private Long id;
    private String itemDescription;
    private Integer qty;
    private ItemCategory category;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    @JoinColumn(name = "CATEGORY_ID", nullable = true)
    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
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

