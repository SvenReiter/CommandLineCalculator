import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserTest {
    Parser p;

    @Test
    void testParserA() {
        p= new Parser("2*3+4");
        Assertions.assertEquals(p.getResult(), 10f, Math.pow(10, (-3)));
    }
    @Test
    void testParserB() {
        p= new Parser("2+3*4");
        Assertions.assertEquals(p.getResult(), 14, Math.pow(10, (-3)));
    }
    @Test
    void testParserC() {
        p= new Parser("144*221+13-23*14+12-13*2*3*23*12/23-11");
        Assertions.assertEquals(p.getResult(), 30580, Math.pow(10, (-3)));
    }
    @Test
    void testParserD() {
        p= new Parser("144*221+13-23*14+12-13");
        Assertions.assertEquals(p.getResult(), 31514, Math.pow(10, (-3)));
    }
    @Test
    void testParserE() {
        p= new Parser("144*221+13-23*14");
        Assertions.assertEquals(p.getResult(), 31515, Math.pow(10, (-3)));
    }
    @Test
    void testParserF() {
        p= new Parser("10*20+13-3");
        Assertions.assertEquals(p.getResult(), 210, Math.pow(10, (-3)));
    }
    @Test
    void testParserG() {
        p= new Parser("1+2-3*4");
        Assertions.assertEquals(p.getResult(), -9, Math.pow(10, (-3)));
    }
    @Test
    void testParserH() {
        p= new Parser("1-2");
        Assertions.assertEquals(p.getResult(), -1, Math.pow(10, (-3)));
    }
    @Test
    void testParserI() {
        p= new Parser("(-1)-1");
        Assertions.assertEquals(p.getResult(), -2, Math.pow(10, (-3)));
    }
    @Test
    void testParserJ() {
        p= new Parser("1-1");
        Assertions.assertEquals(p.getResult(), 0, Math.pow(10, (-3)));
    }
    @Test
    void testParserK() {
        p= new Parser("(-1)-(-1)");
        Assertions.assertEquals(p.getResult(), 0, Math.pow(10, (-3)));
    }
    @Test
    void testParserL() {
        p= new Parser("144*221+13-23*(-14)+12-13*2*3*23*12/23-11");
        Assertions.assertEquals(p.getResult(), 31224, Math.pow(10, (-3)));
    }
    @Test
    void testParserM() {
        p= new Parser("144*221+13-23*14+12-13*2*3*23*12/23-11");
        Assertions.assertEquals(p.getResult(), 30580, Math.pow(10, (-3)));
    }
    @Test
    void testParserN() {
        p= new Parser("(-1)+(-23)-(-4)");
        Assertions.assertEquals(p.getResult(), -20, Math.pow(10, (-3)));
    }
    @Test
    void testParserO() {
        p= new Parser("(-1)+(-23)-(-4)/(-2)");
        Assertions.assertEquals(p.getResult(), -26, Math.pow(10, (-3)));
    }
    @Test
    void testParserP() {
        p= new Parser("(-14)+(12-13)*(-2)");
        Assertions.assertEquals(p.getResult(), -12, Math.pow(10, (-3)));
    }
    @Test
    void testParserQ() {
        p= new Parser("(-14)*(12-13)*(-2)");
        Assertions.assertEquals(p.getResult(), -28, Math.pow(10, (-3)));
    }
    @Test
    void testParserR() {
        p= new Parser("(-14)*(12-13+2)*((-2)+2)");
        Assertions.assertEquals(p.getResult(), 0, Math.pow(10, (-3)));
    }
    @Test
    void testParserS() {
        p= new Parser("(-14)*((12*13)+2)*((-3)+2)");
        Assertions.assertEquals(p.getResult(), 2212, Math.pow(10, (-3)));
    }
    @Test
    void testParserT() {
        p= new Parser("(-14)-((12-13)*2)+((-3)*2)");
        Assertions.assertEquals(p.getResult(), -18, Math.pow(10, (-3)));
    }
    @Test
    void testParserU() {
        p= new Parser("(-14)-(3-((12-13)*3)*2)+((-3)*2)");
        Assertions.assertEquals(p.getResult(), -29, Math.pow(10, (-3)));
    }
    @Test
    void testParserV() {
        p= new Parser("(-14)-(3-(42+(12-13)*3)*2)+((-3)*2)");
        Assertions.assertEquals(p.getResult(), 55, Math.pow(10, (-3)));
    }
    @Test
    void testParserW() {
        p= new Parser("1/2");
        Assertions.assertEquals(p.getResult(), 0.5f, Math.pow(10, (-3)));
    }
    @Test
    void testParserX() {
        p= new Parser("1.2+2.3");
        Assertions.assertEquals(p.getResult(), 3.5f, Math.pow(10, (-3)));
    }
    @Test
    void testParserY() {
        p= new Parser("1.2*2.3");
        Assertions.assertEquals(p.getResult(), 2.76f, Math.pow(10, (-3)));
    }
    @Test
    void testParserZ() {
        p= new Parser("1.2*2.3+4.5/3.8");
        Assertions.assertEquals(p.getResult(), 3.944210f, Math.pow(10, (-6)));
    }
    @Test
    void testParserZA() {
        p= new Parser("1.2*(2.3+4.5)/3.8");
        Assertions.assertEquals(p.getResult(), 2.147368f, Math.pow(10, (-6)));
    }
    @Test
    void testParserZB() {
        p= new Parser("1.2*(2.3+4.5)/3.8");
        Assertions.assertEquals(p.getResult(), 2.14736842105, Math.pow(10, (-11)));
    }
    @Test
    void testParserZC() {
        p= new Parser("1.2*2.3+4.5/3.8");
        Assertions.assertEquals(p.getResult(), 3.94421052632, Math.pow(10, (-11)));
    }
    @Test
    void testParserZD() {
        p= new Parser(
                "(-14.01234)-(3.01234-(42.01234+(12.01234-13.01234)*3.01234)*2.01234)+((-3.01234)*2.01234)");
        Assertions.assertEquals(p.getResult(), 55.3947277244, Math.pow(10, (-11)));
    }
    @Test
    void testParserZE() {
        p= new Parser("1.2*((-2.3)+4.5)/3.8");
        Assertions.assertEquals(p.getResult(), 0.6947368421, Math.pow(10, (-11)));
    }
}
