package com.spring.henallux.springproject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="command_line")
@IdClass(CommandLineEntityId.class)
public class CommandLineEntity {

    public CommandLineEntity(){

    }

    @Id
    @Column(name="product_id")
    private Integer productId;

    @Id
    @Column(name="command_id")
    private Integer commandId;

    @JoinColumn(name="product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private ProductEntity product;

    @JoinColumn(name="command_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private CommandEntity command;

    @Column(name="quantity")
    private int quantity;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCommandId() {
        return commandId;
    }

    public void setCommandId(Integer commandId) {
        this.commandId = commandId;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public CommandEntity getCommand() {
        return command;
    }

    public void setCommand(CommandEntity command) {
        this.command = command;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
