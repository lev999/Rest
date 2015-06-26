package first;

import Clients.HelloRest;
import org.junit.Assert;
import org.junit.Test;

public class MyTest {

    @Test
    public void MyTestResponse(){
        Assert.assertEquals("Response status 200",200, HelloRest.getResponse());
    }
}
