package provider;

import java.util.ResourceBundle;

public class ConfigProviders {
    public static final Integer API_VERSION=Integer.parseInt(getValue("api_version"));
    public static Integer EXPLICITY_WAIT=Integer.parseInt(getValue("explicity_wait"));
    private static final String CONFIG="config";

    private static String getValue(String key){
        return ResourceBundle.getBundle(ConfigProviders.CONFIG).getString(key);
    }
}
