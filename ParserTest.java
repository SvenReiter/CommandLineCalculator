import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ParserTest {
    Parser p;

    @Test
    void testParserA() {
        Parser p= new Parser("2*3+4");
        Assert.assertEquals(p.getResult(), 10f, Math.pow(10, (-3)));
    }
    @Test
    void testParserB() {
        Parser p= new Parser("2+3*4");
        Assert.assertEquals(p.getResult(), 14, Math.pow(10, (-3)));
    }
    @Test
    void testParserC() {
        Parser p= new Parser("144*221+13-23*14+12-13*2*3*23*12/23-11");
        Assert.assertEquals(p.getResult(), 30580, Math.pow(10, (-3)));
    }
    @Test
    void testParserD() {
        Parser p= new Parser("144*221+13-23*14+12-13");
        Assert.assertEquals(p.getResult(), 31514, Math.pow(10, (-3)));
    }
    @Test
    void testParserE() {
        Parser p= new Parser("144*221+13-23*14");
        Assert.assertEquals(p.getResult(), 31515, Math.pow(10, (-3)));
    }
    @Test
    void testParserF() {
        Parser p= new Parser("10*20+13-3");
        Assert.assertEquals(p.getResult(), 210, Math.pow(10, (-3)));
    }
    @Test
    void testParserG() {
        Parser p= new Parser("1+2-3*4");
        Assert.assertEquals(p.getResult(), -9, Math.pow(10, (-3)));
    }
    @Test
    void testParserH() {
        Parser p= new Parser("1-2");
        Assert.assertEquals(p.getResult(), -1, Math.pow(10, (-3)));
    }
    @Test
    void testParserI() {
        Parser p= new Parser("(-1)-1");
        Assert.assertEquals(p.getResult(), -2, Math.pow(10, (-3)));
    }
    @Test
    void testParserJ() {
        Parser p= new Parser("1-1");
        Assert.assertEquals(p.getResult(), 0, Math.pow(10, (-3)));
    }
    @Test
    void testParserK() {
        Parser p= new Parser("(-1)-(-1)");
        Assert.assertEquals(p.getResult(), 0, Math.pow(10, (-3)));
    }
    @Test
    void testParserL() {
        Parser p= new Parser("144*221+13-23*(-14)+12-13*2*3*23*12/23-11");
        Assert.assertEquals(p.getResult(), 31224, Math.pow(10, (-3)));
    }
    @Test
    void testParserM() {
        Parser p= new Parser("144*221+13-23*14+12-13*2*3*23*12/23-11");
        Assert.assertEquals(p.getResult(), 30580, Math.pow(10, (-3)));
    }
    @Test
    void testParserN() {
        Parser p= new Parser("(-1)+(-23)-(-4)");
        Assert.assertEquals(p.getResult(), -20, Math.pow(10, (-3)));
    }
    @Test
    void testParserO() {
        Parser p= new Parser("(-1)+(-23)-(-4)/(-2)");
        Assert.assertEquals(p.getResult(), -26, Math.pow(10, (-3)));
    }
    @Test
    void testParserP() {
        Parser p= new Parser("(-14)+(12-13)*(-2)");
        Assert.assertEquals(p.getResult(), -12, Math.pow(10, (-3)));
    }
    @Test
    void testParserQ() {
        Parser p= new Parser("(-14)*(12-13)*(-2)");
        Assert.assertEquals(p.getResult(), -28, Math.pow(10, (-3)));
    }
    @Test
    void testParserR() {
        Parser p= new Parser("(-14)*(12-13+2)*((-2)+2)");
        Assert.assertEquals(p.getResult(), 0, Math.pow(10, (-3)));
    }
    @Test
    void testParserS() {
        Parser p= new Parser("(-14)*((12*13)+2)*((-3)+2)");
        Assert.assertEquals(p.getResult(), 2212, Math.pow(10, (-3)));
    }
    @Test
    void testParserT() {
        Parser p= new Parser("(-14)-((12-13)*2)+((-3)*2)");
        Assert.assertEquals(p.getResult(), -18, Math.pow(10, (-3)));
    }
    @Test
    void testParserU() {
        Parser p= new Parser("(-14)-(3-((12-13)*3)*2)+((-3)*2)");
        Assert.assertEquals(p.getResult(), -29, Math.pow(10, (-3)));
    }
    @Test
    void testParserV() {
        Parser p= new Parser("(-14)-(3-(42+(12-13)*3)*2)+((-3)*2)");
        Assert.assertEquals(p.getResult(), 55, Math.pow(10, (-3)));
    }
    @Test
    void testParserW() {
        Parser p= new Parser("1/2");
        Assert.assertEquals(p.getResult(), 0.5f, Math.pow(10, (-3)));
    }
    @Test
    void testParserX() {
        Parser p= new Parser("1.2+2.3");
        Assert.assertEquals(p.getResult(), 3.5f, Math.pow(10, (-3)));
    }
    @Test
    void testParserY() {
        Parser p= new Parser("1.2*2.3");
        Assert.assertEquals(p.getResult(), 2.76f, Math.pow(10, (-3)));
    }
    @Test
    void testParserZ() {
        Parser p= new Parser("1.2*2.3+4.5/3.8");
        Assert.assertEquals(p.getResult(), 3.944210f, Math.pow(10, (-6)));
    }
    @Test
    void testParserZA() {
        Parser p= new Parser("1.2*(2.3+4.5)/3.8");
        Assert.assertEquals(p.getResult(), 2.147368f, Math.pow(10, (-6)));
    }
    @Test
    void testParserZB() {
        Parser p= new Parser("1.2*(2.3+4.5)/3.8");
        Assert.assertEquals(p.getResult(), 2.14736842105, Math.pow(10, (-11)));
    }
    @Test
    void testParserZC() {
        Parser p= new Parser("1.2*2.3+4.5/3.8");
        Assert.assertEquals(p.getResult(), 3.94421052632, Math.pow(10, (-11)));
    }
    @Test
    void testParserZD() {
        Parser p= new Parser(
                "(-14.01234)-(3.01234-(42.01234+(12.01234-13.01234)*3.01234)*2.01234)+((-3.01234)*2.01234)"
        );
        Assert.assertEquals(p.getResult(), 55.3947277244, Math.pow(10, (-11)));
    }
}
