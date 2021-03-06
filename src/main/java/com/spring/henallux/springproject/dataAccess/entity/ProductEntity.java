package com.spring.henallux.springproject.dataAccess.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="product")
public class ProductEntity {

    public ProductEntity(){

    }

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="keyname")
    private String keyname;

    @Column(name="unit_price")
    private Double unitPrice;

    @Column(name="image_url")
    private String imageURL;

    @Column(name="discount_percentage")
    private Double discountPercentage;

    @JoinColumn(name="category_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity category;

    @OneToMany(mappedBy = "product")
    private List<CommandLineEntity> commandLines;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public List<CommandLineEntity> getCommandLines() {
        return commandLines;
    }

    public void setCommandLines(List<CommandLineEntity> commandLines) {
        this.commandLines = commandLines;
    }
}
