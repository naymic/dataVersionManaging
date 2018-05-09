import com.company.BaseMetaData;
import com.company.MetaDataManager;
import com.company.testEevent.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMetaDataManager {

    @Test
    public void TestMetaDataMap(){
        List<BaseMetaData> testEventMetaDataVersions = MetaDataManager.getInstance().getEventMetaDataVersions(TestEvent.class);
        assertEquals(5, testEventMetaDataVersions.size());
    }

    @Test
    public void TestMetaDataSort(){
        List<BaseMetaData> testEventMetaDataVersions = MetaDataManager.getInstance().getEventMetaDataVersions(TestEvent.class);
        assertTrue(testEventMetaDataVersions.get(0) instanceof TestMetaData_v1);
        assertTrue(testEventMetaDataVersions.get(1) instanceof TestMetaData_v2);
        assertTrue(testEventMetaDataVersions.get(2) instanceof TestMetaData_v3);
        assertTrue(testEventMetaDataVersions.get(3) instanceof TestMetaData_v4);
        assertTrue(testEventMetaDataVersions.get(4) instanceof TestMetaData_v5);
    }

}
