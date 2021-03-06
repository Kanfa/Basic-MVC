package ml.kanfa.utils;

/**
 * @author Ibrahim Maïga.
 */
public class KFUtils {

    private KFUtils(){}

    public static String ucFirst(String str){
        if (str == null) throw new NullPointerException("Null parameter");
        else if (str.isEmpty()) return "";
        else return Character.toString(str.charAt(0)).toUpperCase().concat(str.substring(1));
    }

    public static String camlCase(String str){
        return format(str, '_');
    }

    private static String format(String str, char delimiter){
        if (str.split(String.valueOf(delimiter)).length == 1) return ucFirst(str);
        else{
            String current = (trim(str, delimiter)).substring(0, str.indexOf(delimiter));
            str = trim(str.substring(str.indexOf(delimiter)), delimiter);
            return ucFirst(current) + (delimiter == '_' ? "" : delimiter) + format(str, delimiter);
        }
    }

    public static String trim(String str, char delimiter) {
        int len = str.length();
        int st = 0;
        char[] val = str.toCharArray();

        while ((st < len) && (val[st] == delimiter)) st++;

        while ((st < len) && (val[len - 1] == delimiter)) len--;

        return ((st > 0) || (len < str.length())) ? str.substring(st, len) : str;
    }
}
