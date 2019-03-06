package com.inventoryservice.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item implements Serializable{

	private static final long serialVersionUID = 4727692840136865516L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long itemId;

	private String itemName;
	private String description;
    private int createdBy;
    private Date creationDate;
    private int lastUpdatedBy;
    private Date lastUpdateDate;
	
	@ManyToOne
	@JoinColumn(name = "item_category_id", nullable = false)
	private ItemCategory itemCategory;
	
	@ManyToOne
	@JoinColumn(name = "item_subcategory_id", nullable = false)
	private ItemSubCategory itemSubCategory;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(int lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    public ItemSubCategory getItemSubCategory() {
        return itemSubCategory;
    }

    public void setItemSubCategory(ItemSubCategory itemSubCategory) {
        this.itemSubCategory = itemSubCategory;
    }
}
