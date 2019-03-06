package com.inventoryservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="item_subcategory")
public class ItemSubCategory implements Serializable {

	private static final long serialVersionUID = -1440421752324464889L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long itemSubcategoryId;

    private String itemSubcategory;
    private int createdBy;
    private Date creationDate;
    private int lastUpdatedBy;
    private Date lastUpdateDate;

	@ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ItemCategory itemCategory;

    @JsonIgnore
	@OneToMany(mappedBy = "itemSubCategory", cascade = CascadeType.ALL)
    private List<Item> items;

    public Long getItemSubcategoryId() {
        return itemSubcategoryId;
    }

    public void setItemSubcategoryId(Long itemSubcategoryId) {
        this.itemSubcategoryId = itemSubcategoryId;
    }

    public String getItemSubcategory() {
        return itemSubcategory;
    }

    public void setItemSubcategory(String itemSubcategory) {
        this.itemSubcategory = itemSubcategory;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
