package com.inventoryservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="item_category")
public class ItemCategory implements Serializable {

	private static final long serialVersionUID = -1177433096317370228L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long itemCategoryId;

    private String itemCategory;
    private int createdBy;
    private Date creationDate;
    private int lastUpdatedBy;
    private Date lastUpdateDate;

	@JsonIgnore
	@OneToMany(mappedBy = "itemCategory", cascade = CascadeType.ALL)
    private List<ItemSubCategory> itemSubCategories;

	@JsonIgnore
	@OneToMany(mappedBy = "itemCategory", cascade = CascadeType.ALL)
    private List<Item> items;

	public Long getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(Long itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}

	public List<ItemSubCategory> getItemSubCategories() {
		return itemSubCategories;
	}

	public void setItemSubCategories(List<ItemSubCategory> itemSubCategories) {
		this.itemSubCategories = itemSubCategories;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
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
}
