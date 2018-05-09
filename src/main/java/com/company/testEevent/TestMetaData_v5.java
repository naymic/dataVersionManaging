package com.company.testEevent;

import com.company.BaseMetaData;

public class TestMetaData_v5 extends TestMetaData_v4 {


    private Integer estimatedTravelTime;

    @Override
    public void upgrade(BaseMetaData baseMetaData) {
        TestMetaData_v5 data = (TestMetaData_v5) baseMetaData;
        data.setEstimatedTravelTime(450);
    }

    public Integer getEstimatedTravelTime() {
        return estimatedTravelTime;
    }

    public void setEstimatedTravelTime(Integer estimatedTravelTime) {
        this.estimatedTravelTime = estimatedTravelTime;
    }


}
