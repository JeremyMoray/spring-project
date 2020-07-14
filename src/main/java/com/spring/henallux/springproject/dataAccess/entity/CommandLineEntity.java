package com.spring.henallux.springproject.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="command_line")
@IdClass(CommandLineEntity.class)
public class CommandLineEntity implements Serializable {

    public CommandLineEntity(){

    }

    @Id
    @JoinColumn(name="product_id", referencedColumnName = "id")
    @ManyToOne
    private ProductEntity product;

    @Id
    @JoinColumn(name="command_id", referencedColumnName = "id")
    @ManyToOne
    private CommandEntity command;

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
}
