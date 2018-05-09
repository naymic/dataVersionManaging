package com.company.ContainerLoadedEvent;

import com.company.BaseMetaData;

/**
 * Event created when a container finish to load
 */
public class ContainerLoadedMetadata_v1 extends BaseMetaData {

    private String id;
    private Double amount;
    private String amountType;
    private String containerType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }


    /**
     * First data version, so nothing need to be executed
     * @param baseMetaData
     */
    @Override
    public void upgrade(BaseMetaData baseMetaData) {

    }

}
