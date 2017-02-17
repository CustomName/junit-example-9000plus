package app.morse;

import app.morse.blackbox.CodeTable;

public interface AppInterface {

    String toMorse(String text, CodeTable.Lang lang);
    String toText(String morseCode, CodeTable.Lang lang);
    String toMorse(String text);
    String toText(String morseCode);
    void setLang(CodeTable.Lang lang);
    void setLang(String lang);
    CodeTable.Lang getLang();

}
