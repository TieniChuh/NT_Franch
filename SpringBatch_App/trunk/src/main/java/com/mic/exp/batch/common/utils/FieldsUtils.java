/*
 * Creation : Dec 9, 2016
 */
package com.mic.exp.batch.common.utils;

import org.apache.commons.lang.StringUtils;

import com.mic.exp.batch.common.Constants;

/**
 * The Class FieldsUtils.
 */
public class FieldsUtils {

    /**
     * Str field format.
     * 
     * @param strField the str field
     * @param size the size
     * @return the string
     */
    public static String strFieldFormat(String strField, int size) {
        return StringUtils.leftPad(strField, size, Constants.STRING_ZERO);
    }

    public static String strComa2Dot(String strInput) {
        return StringUtils.replace(strInput, Constants.SEPARATOR_COMA, Constants.SEPARATOR_DOT);
    }

}
