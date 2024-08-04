package providers;


import java.util.ResourceBundle;

public class DataProviders {
    public static String URL = getValue("url");
    public static String LOGIN=getValue("login");
    public static String PASSWORD=getValue("password");
    private static final String DATA = "data";

    private static String getValue(String key) {
        return ResourceBundle.getBundle(DataProviders.DATA).getString(key);
    }

}



