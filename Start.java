
public class Start {
    public static void main(String[] args) {
//        Parser p= new Parser("2*3+4");
//        Parser p= new Parser("2+3*4");
//        Parser p= new Parser("5*2+3*4");
//        Parser p= new Parser("2*1+5*2+3*4*3");
//        Parser p= new Parser("2*1+5*2+3*4*3-6");
//        Parser p= new Parser("10*2");
//        Parser p= new Parser("10*20");
//        Parser p= new Parser("10*20+13");
//        Parser p= new Parser("10*20+13-3");
//        Parser p= new Parser("144*221+13-3*14");
//        Parser p= new Parser("144*221+13-23*14");
//        Parser p= new Parser("144*221+13-23*14+12-13");
        Parser p= new Parser("144*221+13-23*14+12-13*2*3*23*12/23-11");
        System.out.println(p.getResult());
    }
}
