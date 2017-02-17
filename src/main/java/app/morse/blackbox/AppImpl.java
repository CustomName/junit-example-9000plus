package app.morse.blackbox;

import app.morse.AppInterface;

import java.util.Map;

public class AppImpl implements AppInterface {

    private CodeTable.Lang lang = CodeTable.Lang.RU;

    public String toMorse(String text, CodeTable.Lang lang) {
        StringBuilder result = new StringBuilder();
        Map<String, String> codeTable = CodeTable.getCodeTable(lang, false);

        text = text.toLowerCase();
        for(char ch : text.toCharArray()){
            if(ch == ' '){
                result.append("\u0020\u0020\u0020");
            } else {
                result.append(codeTable.get(String.valueOf(ch)));
                result.append("\u0020");
            }
        }

        return result.toString().trim();
    }

    public String toText(String morseCode, CodeTable.Lang lang) {
        StringBuilder result = new StringBuilder();
        Map<String, String> codeTable = CodeTable.getCodeTable(lang, true);

        for(String code : morseCode.split(" ")){
            code = code.trim();
            if(code.equals("")){
                result.append("\u0020");
            } else {
                result.append(codeTable.get(code));
            }
        }

        return result.toString().trim();
    }

    public String toMorse(String text) {
        return toMorse(text, lang);
    }

    public String toText(String morseCode) {
        return toText(morseCode, lang);
    }

    public void setLang(CodeTable.Lang lang) {
        this.lang = lang;
    }

    public void setLang(String lang) {
        lang = lang.toLowerCase();
        if(lang.equals("ru")){
            this.lang = CodeTable.Lang.RU;
        } else if(lang.equals("en")){
            this.lang = CodeTable.Lang.EN;
        } else{
            throw new IllegalArgumentException("The language with code " + lang + " not supported");
        }
    }

    public CodeTable.Lang getLang() {
        return lang;
    }

}
