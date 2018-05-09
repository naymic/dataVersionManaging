package test.testEevent;

import com.company.BaseEvent;
import com.company.BaseMetaData;

import java.util.ArrayList;
import java.util.List;

public class TestEvent extends BaseEvent {

    public TestEvent(String data){
        super(data);
    }

    @Override
    public List<BaseMetaData> getMetaDataVersions() {
        List<BaseMetaData> metaDataVersions = new ArrayList<>();
        metaDataVersions.add(new TestMetaData_v1());
        metaDataVersions.add(new TestMetaData_v2());
        metaDataVersions.add(new TestMetaData_v3());
        metaDataVersions.add(new TestMetaData_v4());
        metaDataVersions.add(new TestMetaData_v5());
        return metaDataVersions;
    }
}
