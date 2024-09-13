public class Parser {
    char[]pointCalc= new char[]{'*','/'};
    char[]dashCalc= new char[]{'-','+'};

    int result;
    public Parser(String calculation) {
        parse(calculation);
    }

    private void parse(String calculation) {
        for(int i=0; i<calculation.length(); i++) {
            if(calculation.charAt(i)==pointCalc[0] | calculation.charAt(i)==pointCalc[1]) {
                String lv="", rv="";
                int iLv, iRv;
                for(iLv=i-1; iLv>(-1); iLv--) {
                    if(Character.isDigit(calculation.charAt(iLv))) {
                        lv= calculation.charAt(iLv)+lv;
                    }else {
                        break;
                    }
                }
                iLv+=1;

                for(iRv=i+1; iRv<calculation.length(); iRv++) {
                    if(Character.isDigit(calculation.charAt(iRv))) {
                        rv+= calculation.charAt(iRv);
                    }else {
                        break;
                    }
                }
                calculation= new StringBuilder(calculation).replace(iLv, iRv, String.valueOf(calc(lv, calculation.charAt(i), rv))).toString();
                parse(calculation);
                return;     //to break current call, after recursion got initiated
            }
        }

        for(int i=0; i<calculation.length(); i++) {
            if(calculation.charAt(i)==dashCalc[0] | calculation.charAt(i)==dashCalc[1]) {
                String lv="", rv="";
                int iLv, iRv;
                for(iLv=i-1; iLv>(-1); iLv--) {
                    if(Character.isDigit(calculation.charAt(iLv))) {
                        lv= calculation.charAt(iLv)+lv;
                    }else {
                        break;
                    }
                }
                iLv+=1;

                for(iRv=i+1; iRv<calculation.length(); iRv++) {
                    if(Character.isDigit(calculation.charAt(iRv))) {
                        rv+= calculation.charAt(iRv);
                    }else {
                        break;
                    }
                }
                calculation= new StringBuilder(calculation).replace(iLv, iRv, String.valueOf(calc(lv, calculation.charAt(i), rv))).toString();
                parse(calculation);
                return;     //to break current call, after recursion got initiated
            }
        }
        if(calculation.contains(String.valueOf(dashCalc[0])) | calculation.contains(String.valueOf(dashCalc[1]))) {
            parse(calculation);
        }
        result = Integer.parseInt(calculation);
    }

    private int calc(String lV, char c, String rV) {
        switch(c) {
            case '*': {
                return (Integer.parseInt(lV)*Integer.parseInt(rV));
            }
            case '/': {
                return (Integer.parseInt(lV)/Integer.parseInt(rV));
            }
            case '+': {
                return (Integer.parseInt(lV)+Integer.parseInt(rV));
            }
            case '-': {
                return (Integer.parseInt(lV)-Integer.parseInt(rV));
            }
        }
        return 0;
    }

    public int getResult() {
        return result;
    }
}
