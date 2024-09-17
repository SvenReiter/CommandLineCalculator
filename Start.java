
public class Start {
    public static void main(String[] args) {
//        Parser p= new Parser("(-1)-1");
//        Parser p= new Parser("1-1");
//        Parser p= new Parser("(-1)-(-1)");
//        Parser p= new Parser("144*221+13-23*(-14)+12-13*2*3*23*12/23-11");
//        Parser p= new Parser("144*221+13-23*14+12-13*2*3*23*12/23-11");
//        Parser p= new Parser("(-1)+(-23)-(-4)");
        Parser p= new Parser("(-1)+(-23)-(-4)/(-2)");
        System.out.println(p.getResult());
    }
}
