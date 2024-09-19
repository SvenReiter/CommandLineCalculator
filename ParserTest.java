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
    @Test
    void testParserG() {
        Parser p= new Parser("1+2-3*4");
        Assert.assertEquals(p.getResult(), -9);
    }
    @Test
    void testParserH() {
        Parser p= new Parser("1-2");
        Assert.assertEquals(p.getResult(), -1);
    }
    @Test
    void testParserI() {
        Parser p= new Parser("(-1)-1");
        Assert.assertEquals(p.getResult(), -2);
    }
    @Test
    void testParserJ() {
        Parser p= new Parser("1-1");
        Assert.assertEquals(p.getResult(), 0);
    }
    @Test
    void testParserK() {
        Parser p= new Parser("(-1)-(-1)");
        Assert.assertEquals(p.getResult(), 0);
    }
    @Test
    void testParserL() {
        Parser p= new Parser("144*221+13-23*(-14)+12-13*2*3*23*12/23-11");
        Assert.assertEquals(p.getResult(), 31224);
    }
    @Test
    void testParserM() {
        Parser p= new Parser("144*221+13-23*14+12-13*2*3*23*12/23-11");
        Assert.assertEquals(p.getResult(), 30580);
    }
    @Test
    void testParserN() {
        Parser p= new Parser("(-1)+(-23)-(-4)");
        Assert.assertEquals(p.getResult(), -20);
    }
    @Test
    void testParserO() {
        Parser p= new Parser("(-1)+(-23)-(-4)/(-2)");
        Assert.assertEquals(p.getResult(), -26);
    }
    @Test
    void testParserP() {
        Parser p= new Parser("(-14)+(12-13)*(-2)");
        Assert.assertEquals(p.getResult(), -12);
    }
    @Test
    void testParserQ() {
        Parser p= new Parser("(-14)*(12-13)*(-2)");
        Assert.assertEquals(p.getResult(), -28);
    }
    @Test
    void testParserR() {
        Parser p= new Parser("(-14)*(12-13+2)*((-2)+2)");
        Assert.assertEquals(p.getResult(), 0);
    }
    @Test
    void testParserS() {
        Parser p= new Parser("(-14)*((12*13)+2)*((-3)+2)");
        Assert.assertEquals(p.getResult(), 2212);
    }
    @Test
    void testParserT() {
        Parser p= new Parser("(-14)-((12-13)*2)+((-3)*2)");
        Assert.assertEquals(p.getResult(), -18);
    }
}
