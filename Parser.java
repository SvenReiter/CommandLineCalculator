public class Parser {
    char[]pointCalc= new char[]{'*','/'};
    char[]dashCalc= new char[]{'-','+'};
    int result;
    public Parser(String calculation) {
        boolean isNegativeBracketing= false;
        int from=-1, to=-1;
        StringBuilder sb;
        for(int i=0; i<calculation.length(); i++) {
            if(calculation.charAt(i)== '(' && calculation.charAt(i+1)== '-') {
                isNegativeBracketing = true;
            }
            if(calculation.charAt(i)== '(' && !isNegativeBracketing) {
                from= i+1;
            }
            if(calculation.charAt(i)== ')' && !isNegativeBracketing) {
                to= i;
                sb= new StringBuilder((calculation));
                calculation= sb.replace(from-1, to+1, parse(calculation.substring(from, to))).toString();
                i= -1;
                continue;
            }
            if(calculation.charAt(i)== ')' && isNegativeBracketing) {
                isNegativeBracketing= false;
            }
        }
        result= Integer.parseInt(parse(calculation).replaceAll("\\(|\\)",""));  // Erst das verarbeitete/berechnete finale Resultat muss von Klammern befreit werden
    }

    private String parse(String calculation) {
        String lv= "", rv= "";
        while(calculation.indexOf(pointCalc[0])!= (-1) || calculation.indexOf(pointCalc[1])!= (-1)) {
            for (int i = 0; i < calculation.length(); i++) {
                if (calculation.charAt(i) == pointCalc[0] | calculation.charAt(i) == pointCalc[1]) {
                    lv = readLeftValue(calculation, i);
                    rv = readRightValue(calculation, i);
                    calculation = new StringBuilder(calculation).
                            replace(i - (lv.length()),
                                    i + (rv.length() + 1),
                                    calc(lv, calculation.charAt(i), rv)).toString();
                }
            }
        }
        for(int i=0; i<calculation.length(); i++) {
            if(calculation.charAt(i)== dashCalc[0] && calculation.charAt(i-1)!= '(') {
                lv= readLeftValue(calculation, i);
                rv= readRightValue(calculation, i);
                calculation = new StringBuilder(calculation).
                        replace(i - (lv.length()),
                                i + (rv.length() + 1),
                                calc(lv, calculation.charAt(i), rv)).toString();
            }
        }
        while(calculation.indexOf(dashCalc[1])!= (-1)) {
            for (int i = 0; i < calculation.length(); i++) {
                if (calculation.charAt(i) == dashCalc[1]) {
                    lv = readLeftValue(calculation, i);
                    rv = readRightValue(calculation, i);
                    calculation = new StringBuilder(calculation).
                            replace(i - (lv.length()),
                                    i + (rv.length() + 1),
                                    calc(lv, calculation.charAt(i), rv)).toString();
                }
            }
        }
        return calculation;
    }

    private String readRightValue(String calc, int idOp) {
        StringBuilder res= new StringBuilder("");
        for(int i=idOp+1; i<calc.length(); i++) {
            if(Character.isDigit(calc.charAt(i)) | (calc.charAt(i)=='-'&&(calc.length()>i && calc.charAt(i-1)=='(')) |
                    calc.charAt(i)==')' | (((calc.length()-1)>i && calc.charAt(i+1)=='-')&&calc.charAt(i)=='(')) {
                res.append(calc.charAt(i));
            }else break;
        }
        return res.toString();
    }

    private String readLeftValue(String calc, int idOp) {
        StringBuilder res= new StringBuilder("");
        for(int i=idOp-1; i>(-1); i--) {
            if(Character.isDigit(calc.charAt(i)) | (calc.charAt(i)=='-'&&calc.charAt(i-1)=='(') |
                    calc.charAt(i)==')' | (calc.charAt(i+1)=='-'&&calc.charAt(i)=='(')) {
                res.append(calc.charAt(i));
            }else break;
        }
        return res.reverse().toString();
    }

    private String calc(String lV, char c, String rV) {
        int result= 0;
        if(lV.isEmpty() || rV.isEmpty()) return "";
        lV= lV.replaceAll("\\(|\\)","");
        rV= rV.replaceAll("\\(|\\)","");
        switch(c) {
            case '*': {
                result= Integer.parseInt(lV)*Integer.parseInt(rV);
                break;
            }
            case '/': {
                result= Integer.parseInt(lV)/Integer.parseInt(rV);
                break;
            }
            case '+': {
                result= Integer.parseInt(lV)+Integer.parseInt(rV);
                break;
            }
            case '-': {
                result= Integer.parseInt(lV)-Integer.parseInt(rV);
                break;
            }
        }
        if(result<0) {
            return "("+result+")";
        }else {
            return String.valueOf(result);
        }
    }

    public int getResult() {
        return this.result;
    }
}
