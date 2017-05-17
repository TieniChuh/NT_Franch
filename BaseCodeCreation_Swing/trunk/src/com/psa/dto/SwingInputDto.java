/*
 * Creation : Nov 7, 2016
 */
package com.psa.dto;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import com.psa.main.label.CurrentStatusLabel;

public class SwingInputDto {
    private CurrentStatusLabel labelInformation;
    private JTextField strIPValue;
    private JTextField strDataBaseValue;
    private JTextField strTableNameValue;
    private JTextField strPackageNameValue;
    private JTextField strOutputPathValue;
    private JTextField strPasswordValue;
    private JTextField strUserNameValue;
    private JCheckBox checkBox;

    public CurrentStatusLabel getLabelInformation() {
        return labelInformation;
    }

    public void setLabelInformation(CurrentStatusLabel labelInformation) {
        this.labelInformation = labelInformation;
    }

    public JTextField getStrIPValue() {
        return strIPValue;
    }

    public void setStrIPValue(JTextField strIPValue) {
        this.strIPValue = strIPValue;
    }

    public JTextField getStrDataBaseValue() {
        return strDataBaseValue;
    }

    public void setStrDataBaseValue(JTextField strDataBaseValue) {
        this.strDataBaseValue = strDataBaseValue;
    }

    public JTextField getStrTableNameValue() {
        return strTableNameValue;
    }

    public void setStrTableNameValue(JTextField strTableNameValue) {
        this.strTableNameValue = strTableNameValue;
    }

    public JTextField getStrPackageNameValue() {
        return strPackageNameValue;
    }

    public void setStrPackageNameValue(JTextField strPackageNameValue) {
        this.strPackageNameValue = strPackageNameValue;
    }

    public JTextField getStrOutputPathValue() {
        return strOutputPathValue;
    }

    public void setStrOutputPathValue(JTextField strOutputPathValue) {
        this.strOutputPathValue = strOutputPathValue;
    }

    public JTextField getStrPasswordValue() {
        return strPasswordValue;
    }

    public void setStrPasswordValue(JTextField strPasswordValue) {
        this.strPasswordValue = strPasswordValue;
    }

    public JTextField getStrUserNameValue() {
        return strUserNameValue;
    }

    public void setStrUserNameValue(JTextField strUserNameValue) {
        this.strUserNameValue = strUserNameValue;
    }

    public JCheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(JCheckBox checkBox) {
        this.checkBox = checkBox;
    }

}
