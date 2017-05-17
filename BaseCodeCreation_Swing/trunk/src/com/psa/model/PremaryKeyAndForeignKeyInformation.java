/*
 * Creation : Dec 27, 2016
 */
package com.psa.model;

public class PremaryKeyAndForeignKeyInformation {

    private String tableName;
    private String columnName;
    private String constraintName;
    private String referencedTableName;
    private String referencedColumnName;
    private String specialKey;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getConstraintName() {
        return constraintName;
    }

    public void setConstraintName(String constraintName) {
        this.constraintName = constraintName;
    }

    public String getReferencedTableName() {
        return referencedTableName;
    }

    public void setReferencedTableName(String referencedTableName) {
        this.referencedTableName = referencedTableName;
    }

    public String getReferencedColumnName() {
        return referencedColumnName;
    }

    public void setReferencedColumnName(String referencedColumnName) {
        this.referencedColumnName = referencedColumnName;
    }

    public String getSpecialKey() {
        return specialKey;
    }

    public void setSpecialKey(String specialKey) {
        this.specialKey = specialKey;
    }

    public String toString() {
        return tableName + "**" + columnName + "**" + constraintName + "**" + referencedTableName + "**" + referencedColumnName + "**" + specialKey;
    }
}
