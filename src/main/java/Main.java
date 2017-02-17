import app.morse.AppInterface;
import app.morse.blackbox.AppImpl;
import app.morse.blackbox.CodeTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args){

        AppInterface app = new AppImpl();

        System.out.println("exit - end app");
        System.out.println("set lang XX - set language");
        System.out.println("***************************");
        System.out.println("Input text or code of Morse");

        while (true){
            String inputText = "";
            try {
                inputText = in.readLine().toLowerCase();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(inputText.toLowerCase().equals("exit")){
                break;
            }

            if(inputText.toLowerCase().contains("set lang")){
                String langStr = inputText.substring(9, 11);
                app.setLang(langStr);
                System.out.println("Language: " + langStr);
                continue;
            }

            if(inputText.charAt(0) == '*' || inputText.charAt(0) == '-'){
                System.out.println("The code of Morse \"" + inputText + "\" means \"" + app.toText(inputText, app.getLang()) + "\"");
            } else{
                System.out.println("The text \"" + inputText + "\" means \"" + app.toMorse(inputText, app.getLang()) + "\"");
            }
        }

    }

}
