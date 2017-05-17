/*
 * Creation : 17 juin 2015
 */
package com.mic.exp.batch.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * The Class SrpingPropertiesUtil.
 */
public class SpringPropertiesUtil extends PropertyPlaceholderConfigurer {

    /** The properties map. */
    private static Map<String, String> propertiesMap;
    // Default as in PropertyPlaceholderConfigurer
    /** The spring system properties mode. */
    private int springSystemPropertiesMode = SYSTEM_PROPERTIES_MODE_FALLBACK;

    /**
     * {@inheritDoc}
     * 
     * @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer#setSystemPropertiesMode(int)
     */
    @Override
    public void setSystemPropertiesMode(final int systemPropertiesMode) {
        super.setSystemPropertiesMode(systemPropertiesMode);
        springSystemPropertiesMode = systemPropertiesMode;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer#processProperties(org.springframework.beans.factory.config.ConfigurableListableBeanFactory,
     *      java.util.Properties)
     */
    @Override
    protected void processProperties(final ConfigurableListableBeanFactory beanFactory, final Properties props) {
        super.processProperties(beanFactory, props);

        if (MapUtils.isEmpty(propertiesMap)) {
            propertiesMap = new HashMap<>();
        }
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String valueStr = resolvePlaceholder(keyStr, props, springSystemPropertiesMode);
            propertiesMap.put(keyStr, valueStr);
        }
    }

    /**
     * Gets the property.
     * 
     * @param name the name
     * @return the property
     */
    public static String getProperty(final String name) {
        return propertiesMap.get(name);
    }

    /**
     * Gets the property name begin by.
     * 
     * @param begin the begin
     * @return the property name begin by
     */
    public static Map<String, String> getPropertyNameBeginBy(final String begin) {
        Map<String, String> begins = new HashMap<>();
        if (MapUtils.isNotEmpty(propertiesMap)) {
            for (Map.Entry<String, String> e : propertiesMap.entrySet()) {
                if (e.getKey().startsWith(begin)) {
                    begins.put(e.getKey(), e.getValue());
                }
            }
        }
        return begins;
    }
}