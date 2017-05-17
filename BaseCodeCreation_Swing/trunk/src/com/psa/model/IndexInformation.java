/*
 * Creation : Dec 28, 2016
 */
package com.psa.model;

public class IndexInformation {

    private String keyName;
    private String columnName;

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String toString() {
        return keyName + "###" + columnName;
    }
}
