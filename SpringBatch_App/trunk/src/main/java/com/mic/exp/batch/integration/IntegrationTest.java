/*
 * Creation : 16 juin 2015
 */
package com.mic.exp.batch.integration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

/**
 * The Class IntegrationTest.
 */
public class IntegrationTest {

    /** The map properties. */
    private Map<String, Properties> mapProperties = new HashMap<String, Properties>();

    /**
     * Creates the new properties.
     * 
     * @param keyMap the key map
     * @return true, if successful
     */
    public boolean createNewProperties(final String keyMap) {
        boolean res = false;
        if (StringUtils.isNotBlank(keyMap)) {
            this.mapProperties.put(keyMap, new Properties());
            res = true;
        }
        return res;
    }

    /**
     * Adds the new key value.
     * 
     * @param keyMap the key map
     * @param key the key
     * @param value the value
     * @return true, if successful
     */
    public boolean addNewKeyValue(final String keyMap, final String key, final String value) {
        boolean res = false;
        if (MapUtils.isNotEmpty(this.mapProperties) && this.mapProperties.containsKey(keyMap)) {
            this.mapProperties.get(keyMap).setProperty(key, value);
            res = true;
        }

        return res;
    }

    /**
     * Persist properties.
     * 
     * @param keyMap the key map
     * @param propertiesFileName the properties file name. This file must present in the classpath loaded by the classPathLoader
     * @return true, if successful
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public boolean persistProperties(final String keyMap, final String propertiesFileName) throws IOException {
        boolean res = false;
        if (MapUtils.isNotEmpty(this.mapProperties) && this.mapProperties.containsKey(keyMap) && StringUtils.isNotBlank(propertiesFileName)) {
            URL urlProp = this.getClass().getClassLoader().getResource(propertiesFileName);
            File f = new File(urlProp.getPath());
            OutputStream out = new FileOutputStream(f);
            this.mapProperties.get(keyMap).store(out, "");
            res = true;
        }
        return res;
    }
}
