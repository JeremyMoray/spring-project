package com.spring.henallux.springproject.dataAccess.entity;

import java.io.Serializable;

public class CommandLineEntityId implements Serializable {

    private Integer productId;

    private Integer commandId;

    public CommandLineEntityId(){

    }

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
}
