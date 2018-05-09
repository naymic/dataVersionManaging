package test.testEevent;

import com.company.BaseMetaData;

public class TestMetaData_v2 extends TestMetaData_v1{

    private String test2;

    @Override
    public void upgrade(BaseMetaData baseMetaData) {
        TestMetaData_v2 metaDataV2 = (TestMetaData_v2) baseMetaData;
        metaDataV2.setTest2("test2VarValue");
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }
}
