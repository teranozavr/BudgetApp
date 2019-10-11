package teranozavr.helpers;

/**
 * Created by Admin on 21.09.2019.
 */
public class Colors {
    public static boolean verifyColor(String st, String color){
        switch (color.toLowerCase()) {
            case "green":
                return st.contains("rgb(0, 100, 0)");
            case "black":
                return st.contains("rgb(0, 0, 0)");
            case "red":
                return st.contains("rgb(178, 34, 34)");
            case "lightgreen":
                return st.contains("rgba(213, 238, 213, 1)");
            case "lightred":
                return st.contains("rgba(238, 213, 213, 1)");
        }
        return false;
    }
}
