package provider;

import java.util.ResourceBundle;

public class ConfigProviders {
    public static final Double API_VERSION = Double.parseDouble(getValue("api_version"));
    public static Integer EXPLICITY_WAIT = Integer.parseInt(getValue("explicity_wait"));
    private static final String CONFIG = "config";

    private static String getValue(String key) {
        return ResourceBundle.getBundle(ConfigProviders.CONFIG).getString(key);
    }
}
