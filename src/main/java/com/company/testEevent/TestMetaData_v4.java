package com.company.testEevent;

import com.company.BaseMetaData;

import java.util.Date;

public class TestMetaData_v4 extends TestMetaData_v3 {

    private Date created;

    @Override
    public void upgrade(BaseMetaData baseMetaData) {
        TestMetaData_v4 data = (TestMetaData_v4) baseMetaData;
        data.setCreated(new Date(112505));
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
