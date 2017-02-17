package app.morse.blackbox;

import java.util.HashMap;
import java.util.Map;

public class CodeTable {

    private static final String RU_CODES = "а*- б-*** в*-- г--* д-** е* ж*** з--** и** й*--- к-*- л*-** " +
                                            "м-- н-* о--- п*--* р*-* с*** т- у**- ф**-* х**** ц-*-* ч---* " +
                                            "ш---- щ--*- ъ--*-- ы-*-- ь-**- э**-** ю**-- я*-*-";

    private static final String EN_CODES = "a*- b*-- g--* d-** e* v***- z--** i** j*--- k-*- l*-** m-- n-* " +
                                            "o*** p*--* r*-* s*** t- u**- f**-* h**** c-*-* q--*- y-*-- w*-- x-**-";

    private static final String NUM_CODES = "1*---- 2**--- 3***-- 4****- 5***** 6-**** 7--*** 8---** 9----* 0-----";

    private static final String SYMBOL_CODES = ".****** ,*-*-*- :---*** ;-*-*-* (-*--*- )-*--*- '*----* \"*-**-* --****- /-**-* ?**--** !--**-- @*--*-*";

    /**
     * @param lang is language of code table
     * @param isReverse if false - key is letter, if true - key is code of Morse
     */
    public static Map<String, String> getCodeTable(Lang lang, boolean isReverse){
        Map<String, String> result = new HashMap<String, String>();
        String codeStr;

        switch (lang){
            case RU:
                codeStr = RU_CODES;
                break;
            case EN:
                codeStr = EN_CODES;
                break;
            default:
                throw new IllegalArgumentException("The language not supported");
        }

        codeStr += " " + NUM_CODES;
        codeStr += " " + SYMBOL_CODES;

        for(String code : codeStr.split(" ")){
            code = code.trim();
            if(isReverse){
                result.put(code.substring(1), String.valueOf(code.charAt(0)));
            } else {
                result.put(String.valueOf(code.charAt(0)), code.substring(1));
            }
        }

        return result;
    }

    public enum Lang{
        RU,
        EN
    }

}
