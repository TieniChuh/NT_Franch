/*
 * Creation : Nov 3, 2016
 */
package com.psa.utils;

import java.io.File;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

import com.psa.model.FieldInformation;
import com.psa.model.IndexInformation;
import com.psa.model.PremaryKeyAndForeignKeyInformation;

public class ModelUtils {

    public static String typeTrans(String type, Set<String> importList) {
        if (type.contains("tinyint")) {
            return "boolean";
        } else if (type.equals("bigint")) {
            return "Long";
        } else if (type.contains("int")) {
            return "Integer";
        } else if (type.contains("varchar") || type.contains("text") || type.contains("enum") || type.contains("set")) {
            return "String";
        } else if (type.contains("date") || type.contains("time") || type.contains("datetime") || type.contains("timestamp")) {
            importList.add(Constants.STR_IMPORT_DATE);
            return "Date";
        } else if (type.contains("binary") || type.contains("blob")) {
            return "byte[]";
        } else {
            return "String";
        }
    }

    public static String fieldTrans(String field) {
        StringBuffer returnStr = new StringBuffer("");
        field = field.toLowerCase();
        String[] splitField = field.split("_");
        returnStr.append(splitField[0]);
        for (int i = 1; i < splitField.length; i++) {
            returnStr.append(CommonUtils.upperFirestChar(splitField[i]));
        }
        return returnStr.toString();
    }

    public static void main(String[] args) {
        StringBuffer returnStr = new StringBuffer("");
        String field = "CONTRACT_ID";
        field = field.toLowerCase();
        String[] splitField = field.split("_");

        System.out.println(returnStr.toString());

    }

    /**
     * @param type
     * @return
     */
    public static String getMethodStr(String fieldName, String type) {
        String formatedFiedlName = ModelUtils.fieldTrans(fieldName);
        String methodName = CommonUtils.upperFirestChar(formatedFiedlName);
        StringBuilder get = new StringBuilder("\n\tpublic ");
        get.append(type).append(" ");
        get.append("get");
        get.append(methodName);
        get.append("(){").append("\r\n\t\treturn this.").append(formatedFiedlName).append(";\r\n\t}\r\n");

        StringBuilder set = new StringBuilder("\tpublic void ");
        set.append("set");
        set.append(methodName);
        set.append("(").append(type).append(" ").append(formatedFiedlName).append("){\r\n\t\tthis.").append(formatedFiedlName).append("=")
                .append(formatedFiedlName).append(";\r\n\t}\r\n");
        get.append(set);
        return get.toString();
    }

    public static String getFieldStr(String fieldName, String type, String defaultValue) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t").append(MessageFormat.format(Constants.STR_FIELD_ANNOTATION_COLUMN, fieldName));
        sb.append("\t").append("private ").append(type).append(" ").append(ModelUtils.fieldTrans(fieldName));
        if (StringUtils.isNotBlank(defaultValue)) {
            if (StringUtils.equals("Date", type)) {
                //
                sb.append(" ; //default Value is \"").append(defaultValue).append("\"");
            } else if (StringUtils.equals("Long", type) || StringUtils.equals("Integer", type)) {
                boolean dvIsNumb = true;
                try {
                    Long.parseLong(defaultValue);
                } catch (NumberFormatException e) {
                    sb.append(" ; //default Value is \"").append(defaultValue).append("\"");
                    dvIsNumb = false;
                }
                if (dvIsNumb) {
                    sb.append(" = ").append(defaultValue);
                }

            } else if (StringUtils.equals("boolean", type)) {
                if (StringUtils.equalsIgnoreCase("true", defaultValue) || StringUtils.equalsIgnoreCase("false", defaultValue)) {
                    sb.append(" = ").append(defaultValue);
                } else {
                    sb.append(" ; //default Value is \"").append(defaultValue).append("\"");
                }
            } else {
                sb.append(" = \"").append(defaultValue).append("\"");
            }
        }

        sb.append(";\r\n");
        return sb.toString();
    }

    public static String getFieldStrPrimaryKey(String fieldName, String type, String className, Set<String> importList) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t").append(MessageFormat.format(Constants.STR_FIELD_ANNOTATION_SINGLE_PK, className));
        sb.append("\t").append("private ").append(type).append(" ").append(ModelUtils.fieldTrans(fieldName));
        sb.append("; \r\n");
        importList.add(Constants.STR_IMPORT_Id);
        importList.add(Constants.STR_IMPORT_GeneratedValue);
        importList.add(Constants.STR_IMPORT_GenerationType);
        importList.add(Constants.STR_IMPORT_TableGenerator);
        return sb.toString();
    }

    public static String getFieldStrForeignKey(String fieldName, String refClassName, Set<String> importList) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t").append(MessageFormat.format(Constants.STR_FIELD_ANNOTATION_FK, fieldName));
        sb.append("\t").append("private ").append(CommonUtils.transClassName(refClassName)).append(" ").append(ModelUtils.fieldTrans(fieldName));
        sb.append("; \r\n");
        importList.add(Constants.STR_IMPORT_MANYTOONE);
        importList.add(Constants.STR_IMPORT_JOINCOLUMN);

        return sb.toString();
    }

    public static String getOverwriteHashCodeAndEquals(List<IndexInformation> indexList, String baseClassName, Set<String> importList) {
        StringBuffer hashCodeStr = new StringBuffer();
        StringBuffer equalsStr = new StringBuffer();
        hashCodeStr
                .append("\n\t/**\n\t * {@inheritDoc}\n\t * \n\t * @see java.lang.Object#hashCode()\n\t */\n\t@Override\n\tpublic int hashCode() {");
        equalsStr
                .append("\n\t/**\n\t * {@inheritDoc}\n\t * \n\t * @see java.lang.Object#equals(java.lang.Object)\n\t */\n\t@Override\n\tpublic boolean equals(Object obj) {\n\t    if (obj == this) {\n\t        return true;\n\t    }\n\n\t    if (obj instanceof ")
                .append(baseClassName).append(") {");
        StringBuffer hashCodeTemp = new StringBuffer();
        StringBuffer equalsTemp = new StringBuffer();
        for (IndexInformation indexInfoTemp : indexList) {
            String formatedColName = ModelUtils.fieldTrans(indexInfoTemp.getColumnName());
            hashCodeTemp.append(".append(this.").append(formatedColName).append(")");
            equalsTemp.append(".append(this.").append(formatedColName).append(", other.").append(formatedColName).append(")");
        }
        hashCodeStr.append(MessageFormat.format(Constants.STR_BASECLASS_METHOD_HASHCODE, hashCodeTemp.toString())).append("}\n\n");
        equalsStr.append(MessageFormat.format(Constants.STR_BASECLASS_METHOD_EQUALS, baseClassName, equalsTemp.toString())).append(
                "}\n\n\t    return false;\n\t}\n\n");

        importList.add(Constants.STR_IMPORT_EQUALSBUILDER);
        importList.add(Constants.STR_IMPORT_HASHCODEBUILDER);
        return hashCodeStr.append(equalsStr).toString();
    }

    public static PremaryKeyAndForeignKeyInformation validSpecialKey(String currentFieldName,
            List<PremaryKeyAndForeignKeyInformation> primaryKeyList, List<PremaryKeyAndForeignKeyInformation> foreignKeyList) {
        PremaryKeyAndForeignKeyInformation specialKeyDto = null;
        for (PremaryKeyAndForeignKeyInformation premaryKeyAndForeignKeyInformation : primaryKeyList) {
            if (StringUtils.equals(currentFieldName, premaryKeyAndForeignKeyInformation.getColumnName())) {
                specialKeyDto = premaryKeyAndForeignKeyInformation;
                specialKeyDto.setSpecialKey(Constants.STR_PRIMARY_KEY);
            }
        }
        for (PremaryKeyAndForeignKeyInformation premaryKeyAndForeignKeyInformation : foreignKeyList) {
            if (StringUtils.equals(currentFieldName, premaryKeyAndForeignKeyInformation.getColumnName())) {
                specialKeyDto = premaryKeyAndForeignKeyInformation;
                specialKeyDto.setSpecialKey(Constants.STR_FOREIGN_KEY);
            }
        }
        return specialKeyDto;
    }

    public static String createMultiplePremaryKeyClass(String outputdir, String packname, String tableName, List<FieldInformation> premaryKeyList,
            List<IndexInformation> indexList) {
        // init baseClass File eg:BaseA2CQTCONTRACT.java
        File mutiPKFile = new File(outputdir + Constants.STR_MODEL_PATH_MUTI_PK, MessageFormat.format(Constants.STR_FILENAME,
                "PK" + CommonUtils.transClassName(tableName)));
        String basePackageInfo = MessageFormat.format(Constants.STR_MUTI_PK_PACKAGEINFO, packname);
        StringBuffer baseImportInfo = new StringBuffer(Constants.STR_IMPORT_EMBEDDABLE);
        baseImportInfo.append(Constants.STR_IMPORT_SERIALIZABLE);
        StringBuffer baseClassInfo = new StringBuffer(CommonUtils.commentsInformation());
        baseClassInfo.append(Constants.STR_CLASS_ANNOTATION_EMBEDDABLE);
        baseClassInfo.append("public class PK").append(CommonUtils.transClassName(tableName)).append(" implements Serializable {\r\n");
        StringBuffer basePropFields = new StringBuffer(Constants.STR_SERIAL_VERSION_UID_BASECLASS);
        if (indexList.size() > 0) {
            basePropFields.append(Constants.STR_HASHCODEBUILDER);
        }
        StringBuffer baseFields = new StringBuffer();
        StringBuffer baseMethods = new StringBuffer();

        // create BaseClass Inofrmation contains 3 parts:
        Set<String> importList = new HashSet();
        for (FieldInformation fieldInformationTemp : premaryKeyList) {
            // for the common field
            baseFields.append(ModelUtils.getFieldStr(fieldInformationTemp.getColumnName(),
                    ModelUtils.typeTrans(fieldInformationTemp.getDataType(), importList), fieldInformationTemp.getColumnDefault()));
            importList.add(Constants.STR_IMPORT_COLUMN);

            // #### baseMethods####

            baseMethods.append(ModelUtils.getMethodStr(fieldInformationTemp.getColumnName(),
                    ModelUtils.typeTrans(fieldInformationTemp.getDataType(), importList)));

        }
        // add two method in BaseClase: HashCode() and equals();
        if (indexList.size() > 0) {
            baseMethods.append(ModelUtils.getOverwriteHashCodeAndEquals(indexList, "PK" + CommonUtils.transClassName(tableName), importList));
        }
        // add importInformation, sort the importList
        TreeSet<String> tsForImportList = new TreeSet(importList);
        tsForImportList.comparator();
        for (String temp : tsForImportList) {
            baseImportInfo.append(temp);
        }

        baseClassInfo.append(basePropFields);
        baseClassInfo.append(baseFields);
        baseClassInfo.append(baseMethods);
        baseClassInfo.append("\r\n");
        baseClassInfo.append("}");
        CommonUtils.writeFile(mutiPKFile, basePackageInfo, baseImportInfo.toString(), baseClassInfo.toString());

        return "PK" + CommonUtils.transClassName(tableName);
    }
}
