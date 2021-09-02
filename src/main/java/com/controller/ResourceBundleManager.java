package com.controller;

import java.util.Locale;
import java.util.ResourceBundle;

public abstract class ResourceBundleManager {
    private static final String UA = "ua";
    private static final String EN = "en";

    private static final String RESOURCE_BUNDLE_NAME = "messages";
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, new Locale(UA));

    public static String getString(String key){
        return resourceBundle.getString(key);
    }
}
