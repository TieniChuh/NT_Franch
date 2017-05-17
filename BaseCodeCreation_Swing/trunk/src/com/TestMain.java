/*
 * Creation : Nov 30, 2016
 */
package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.psa.utils.ModelUtils;

public class TestMain {

    public static void main(String[] args) {
        String sqlstr = "CREATE TABLE `A2CQTACTOR` (                                                                                      "
                + "/   `ID` bigint(20) NOT NULL,                                                                                     "
                + "/   `CONTRACT_ID` bigint(20) NOT NULL,                                                                            "
                + "/   `NUMBER_BCU` varchar(20) COLLATE utf8_bin DEFAULT NULL,                                                       "
                + "/   `REF_PERSON` varchar(20) COLLATE utf8_bin DEFAULT NULL,                                                       "
                + "/   `USER_ROLE_ID` int(11) NOT NULL,                                                                              "
                + "/   `SIREN` varchar(9) COLLATE utf8_bin DEFAULT NULL,                                                             "
                + "/   `AUDIT_LAST_UPDATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,            "
                + "/   `AUDIT_LAST_UPDATE_USER` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT 'A2C_BATCH',                           "
                + "/   PRIMARY KEY (`ID`),                                                                                           "
                + "/   KEY `A2CQXACTOR2` (`CONTRACT_ID`,`NUMBER_BCU`),                                                               "
                + "/   KEY `A2CQIACTOR1` (`CONTRACT_ID`),                                                                            "
                + "/   KEY `A2CQIACTOR2` (`USER_ROLE_ID`),                                                                           "
                + "/   KEY `A2CQXACTOR1` (`CONTRACT_ID`,`USER_ROLE_ID`,`NUMBER_BCU`),                                                "
                + "/   KEY `A2CQXACTOR3` (`NUMBER_BCU`),                                                                             "
                + "/   KEY `A2CQXACTOR4` (`REF_PERSON`),                                                                             "
                + "/   CONSTRAINT `A2CQIACTOR1` FOREIGN KEY (`CONTRACT_ID`) REFERENCES `A2CQTCONTRACT` (`ID`),                       "
                + "/   CONSTRAINT `A2CQIACTOR2` FOREIGN KEY (`USER_ROLE_ID`) REFERENCES `A2CQTREF_NOMEN` (`ID`)                      "
                + "/ ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin                                                           ";
        String lines[] = sqlstr.split("/");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            System.out.println("############################");
            System.out.println(line);
            String regex = "\\s*`([^`]*)`\\s*(\\w+[^ ]*)\\s*(NOT\\s+NULL\\s*|COLLATE\\s+utf8_bin\\s*|COLLATE\\s+utf8_bin\\s+NOT\\s+NULL\\s*)?(DEFAULT\\s*([^ ]*|NULL|'0'|''|CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)\\s*)?(COMMENT\\s*'([^']*)')?\\s*,\\s*";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(line);
            while (m.find()) {
                String colName = m.group(1);
                String type = "";// ModelUtils.typeTrans(m.group(2), new StringBuffer());
                String cmt = m.group(7);
                String field = ModelUtils.fieldTrans(colName);
                System.out.println(field);
                System.out.println(type);
                System.out.println(cmt);
            }
            if (i == lines.length - 1) {

            }

        }

        // select
        // TABLE_NAME,COLUMN_NAME,CONSTRAINT_NAME, REFERENCED_TABLE_NAME,REFERENCED_COLUMN_NAME
        // . INFORMATION_SCHEMA.KEY_COLUMN_USAGE
        // where
        // TABLE_NAME='A2CQTACTOR';
    }
}
