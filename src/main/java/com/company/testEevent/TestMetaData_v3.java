package com.company.testEevent;

import com.company.BaseMetaData;

public class TestMetaData_v3 extends TestMetaData_v2{

    private Double totalPrice;

    @Override
    public void upgrade(BaseMetaData baseMetaData) {
        TestMetaData_v3 testMetaDataV3 = (TestMetaData_v3) baseMetaData;
        testMetaDataV3.totalPrice = testMetaDataV3.getPrice() * testMetaDataV3.getCount();
        baseMetaData = testMetaDataV3;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
