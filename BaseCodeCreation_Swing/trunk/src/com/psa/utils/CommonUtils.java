/*
 * Creation : Nov 3, 2016
 */
package com.psa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.psa.dto.SwingInputDto;

public class CommonUtils {

    public static String transClassName(String str) {
        return str.substring(0, 1).toUpperCase().concat(str.substring(1).toLowerCase());
    }

    public static String upperFirestChar(String src) {
        return src.substring(0, 1).toUpperCase().concat(src.substring(1));
    }

    public static String lowerFirestChar(String src) {
        return src.substring(0, 1).toLowerCase().concat(src.substring(1));
    }

    public static void importDefaultSetting(Properties propertyFile, String configFile, SwingInputDto swingInputDto) {
        File config = new File(configFile);
        if (config.exists()) {
            try {
                InputStream is = new FileInputStream(config);
                propertyFile.load(is);
                is.close();
                setUIDefaultVal(propertyFile, swingInputDto);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            try {
                config.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void setUIDefaultVal(Properties propertyFile, SwingInputDto swingInputDto) {
        swingInputDto.getStrIPValue().setText(propertyFile.getProperty("host", "localhost"));
        swingInputDto.getStrDataBaseValue().setText(propertyFile.getProperty("database", ""));
        swingInputDto.getStrUserNameValue().setText(propertyFile.getProperty("user", "root"));
        swingInputDto.getStrPasswordValue().setText(propertyFile.getProperty("pass", "123456"));
        swingInputDto.getStrPackageNameValue().setText(propertyFile.getProperty("packname", "com.psa.yourProjectName.db"));
        swingInputDto.getStrOutputPathValue().setText(propertyFile.getProperty("dirstr", ""));
        swingInputDto.getStrTableNameValue().setText(propertyFile.getProperty("tablename", ""));
    }

    public static void exportUserSetting(Properties propertyFile, String configFile, SwingInputDto swingInputDto) {
        String host = swingInputDto.getStrIPValue().getText();
        String database = swingInputDto.getStrDataBaseValue().getText();
        String user = swingInputDto.getStrUserNameValue().getText();
        String pass = swingInputDto.getStrPasswordValue().getText();
        String packname = swingInputDto.getStrPackageNameValue().getText();
        String dirstr = swingInputDto.getStrOutputPathValue().getText();
        String tablename = swingInputDto.getStrTableNameValue().getText();

        propertyFile.setProperty("host", host);
        propertyFile.setProperty("database", database);
        propertyFile.setProperty("user", user);
        propertyFile.setProperty("pass", pass);
        propertyFile.setProperty("packname", packname);
        propertyFile.setProperty("dirstr", dirstr);
        propertyFile.setProperty("tablename", tablename);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            OutputStream out = new FileOutputStream(configFile);
            propertyFile.store(out, "save user setting," + sdf.format(new Date()));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void setTips(String msg, SwingInputDto swingInputDto) {
        swingInputDto.getLabelInformation().setText(msg);
        swingInputDto.getLabelInformation().paintImmediately(swingInputDto.getLabelInformation().getBounds());
    }

    public static void writeFile(File file, String packageInfo, String importInfo, String classInfo) {
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(packageInfo);
            fw.write(importInfo);
            fw.write(classInfo);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String commentsInformation() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuffer comment = new StringBuffer();
        comment.append("/**\r\n");
        comment.append(" *\r\n");
        comment.append(" *This Class is created by PSA Dao creation Tool \r\n");
        comment.append(" *\r\n");
        comment.append(" *@author E466414 \r\n");
        comment.append(" *@since ");
        comment.append(sdf.format(new Date()));
        comment.append("\r\n */\r\n");
        return comment.toString();
    }
}
