package test;

import org.junit.jupiter.api.Test;
import test.testEevent.TestMetaData_v4;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMetaData {

    @Test
    public void testMetaDataVersion(){
        TestMetaData_v4 metaDataV4 = new TestMetaData_v4();

        assertEquals(Optional.of(4), Optional.of(metaDataV4.getMetaDataVersion()));
    }

}
