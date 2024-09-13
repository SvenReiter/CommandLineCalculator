
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class ParserTest {
    Parser p;

    @Test
    void testParserA() {
        Parser p= new Parser("2*3+4");
        Assert.assertEquals(p.getResult(), 10);
    }
    @Test
    void testParserB() {
        Parser p= new Parser("2+3*4");
        Assert.assertEquals(p.getResult(), 14);
    }
    @Test
    void testParserC() {
        Parser p= new Parser("144*221+13-23*14+12-13*2*3*23*12/23-11");
        Assert.assertEquals(p.getResult(), 30580);
    }
    @Test
    void testParserD() {
        Parser p= new Parser("144*221+13-23*14+12-13");
        Assert.assertEquals(p.getResult(), 31514);
    }
    @Test
    void testParserE() {
        Parser p= new Parser("144*221+13-23*14");
        Assert.assertEquals(p.getResult(), 31515);
    }
    @Test
    void testParserF() {
        Parser p= new Parser("10*20+13-3");
        Assert.assertEquals(p.getResult(), 210);
    }
}
