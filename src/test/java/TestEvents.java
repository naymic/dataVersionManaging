import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import com.company.testEevent.TestEvent;
import com.company.testEevent.TestMetaData_v1;
import com.company.testEevent.TestMetaData_v5;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestEvents {

    private final Gson gson = new Gson();
    private static final String data_v1 = "{\"version\":1,\"name\":\"test event\", \"price\":50.5, \"type\":\"test type\", \"count\":3}";
    private static final String data_v3 = "{\"totalPrice\":151.5,\"test2\":\"test2VarValue\",\"name\":\"test event\",\"count\":3,\"price\":50.5,\"type\":\"test type\",\"version\":3}";
    private static final String data_v5 = "{\"estimatedTravelTime\":450,\"created\":\"Jan 1, 1970 1:01:52 AM\",\"totalPrice\":151.5,\"test2\":\"test2VarValue\",\"name\":\"test event\",\"count\":3,\"price\":50.5,\"type\":\"test type\",\"version\":5}";

    @Test
    public void testEventDataVersions(){
        TestEvent event = new TestEvent(data_v1);
        assertEquals(event.getMetaDataVersions().size(), 5);
    }

    @Test
    public void testEventDataVersionHistory(){
        TestEvent event = new TestEvent(data_v1);
        assertEquals(Optional.of(1), Optional.of(event.getMetaDataVersions().get(0).getMetaDataVersion()));
        assertTrue(event.getMetaDataVersions().get(0) instanceof TestMetaData_v1);

        assertEquals(Optional.of(5), Optional.of(event.getMetaDataVersions().get(4).getMetaDataVersion()));
        assertTrue(event.getMetaDataVersions().get(4) instanceof TestMetaData_v5);
    }

    @Test
    public void testMetaDataUpgrade(){
        TestEvent event = new TestEvent(data_v1);
        TestMetaData_v5 eventData = (TestMetaData_v5) event.getMetaData();
        assertTrue(data_v5.equals(gson.toJson(eventData)));


        TestEvent event1 = new TestEvent(data_v3);
        TestMetaData_v5 eventData1 = (TestMetaData_v5) event1.getMetaData();
        assertTrue(data_v5.equals(gson.toJson(eventData1)));
    }

}
