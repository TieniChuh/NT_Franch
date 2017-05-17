/*
 * Creation : Dec 27; 2016
 */
package com.psa.model;

public class FieldInformation {

    private String ordinalPosition;
    private String columnName;
    private String dataType;
    private String characterMaximumLength;
    private String columnDefault;
    private String formattedColumnName;

    public String getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(String ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getCharacterMaximumLength() {
        return characterMaximumLength;
    }

    public void setCharacterMaximumLength(String characterMaximumLength) {
        this.characterMaximumLength = characterMaximumLength;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    public String getFormattedColumnName() {
        return formattedColumnName;
    }

    public void setFormattedColumnName(String formattedColumnName) {
        this.formattedColumnName = formattedColumnName;
    }

    public String toString() {
        return ordinalPosition + "**" + columnName + "**" + dataType + "**" + characterMaximumLength + "**" + columnDefault + "**"
                + formattedColumnName;
    }
}
