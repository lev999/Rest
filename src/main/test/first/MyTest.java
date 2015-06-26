package first;

import firstClient.FirstClient;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pc-users on 6/26/2015.
 */
public class MyTest {

    @Test
    public void MyTestResponse(){
        Assert.assertEquals("Response status 200",200,FirstClient.getResponse());
    }
}
