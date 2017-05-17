/*
 * Creation : Nov 3, 2016
 */
package keyPress.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import keyPress.dto.ConfigDto;

public class CommonUtils {

    public static ConfigDto setUIDefaultVal(Properties propertyFile) {
        ConfigDto configDto = new ConfigDto();
        configDto.setKeyQtime(Integer.parseInt(propertyFile.getProperty("pass", "0")));
        configDto.setKeyWtime(Integer.parseInt(propertyFile.getProperty("wtime", "0")));
        configDto.setKeyEtime(Integer.parseInt(propertyFile.getProperty("etime", "0")));
        configDto.setKeyRtime(Integer.parseInt(propertyFile.getProperty("rtime", "0")));
        configDto.setKeyTtime(Integer.parseInt(propertyFile.getProperty("ttime", "0")));
        return configDto;
    }

    public static ConfigDto importDefaultSetting(String configFile) {
        ConfigDto configDto = new ConfigDto();
        Properties propertyFile = new Properties();
        File config = new File(configFile);
        if (config.exists()) {
            try {
                InputStream is = new FileInputStream(config);
                propertyFile.load(is);
                is.close();
                configDto = setUIDefaultVal(propertyFile);
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
        return configDto;
    }
}
