import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void testBase() {
        String actRes = Main.number("01-AA-01");
        String expRes = "01AA02";
        Assert.assertEquals(expRes, actRes);
    }

    @Test
    public void testSecondPart() {
        String actRes = Main.number("01-AZ-99");
        String expRes = "01BA01";
        Assert.assertEquals(expRes, actRes);
    }

    @Test
    public void testThirdPart() {
        String actRes = Main.number("01-ZZ-99");
        String expRes = "02AA01";
        Assert.assertEquals(expRes, actRes);
    }
}