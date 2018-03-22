package ua.nure.garmash.Practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 11/19/2017.
 */
public class Part3 {
    public static void main(String[] args) {
        System.out.println(convert(fileSource));
    }

    public static final String INPUT = "part3.txt";
    public static String fileSource = Util.getInput(INPUT);

    public static String convert(String input) {

        Pattern p = Pattern.compile("\\b[\\w'\\S]+\\s*");
        Matcher m = p.matcher(input);
        StringBuilder resultString = new StringBuilder();

        while (m.find()) {
            resultString.append(m.group().substring(0,1).toUpperCase()).append(m.group().substring(1));

        }
        return resultString.toString();
    }
}
