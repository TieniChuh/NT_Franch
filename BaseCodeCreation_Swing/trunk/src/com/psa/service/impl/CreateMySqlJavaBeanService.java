/*
 * Creation : Nov 7, 2016
 */
package com.psa.service.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.filechooser.FileSystemView;

import org.apache.commons.lang3.StringUtils;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.psa.dto.SwingInputDto;
import com.psa.model.FieldInformation;
import com.psa.model.IndexInformation;
import com.psa.model.PremaryKeyAndForeignKeyInformation;
import com.psa.service.ICreateJavaBeanService;
import com.psa.utils.CommonUtils;
import com.psa.utils.Constants;
import com.psa.utils.DBManager;
import com.psa.utils.ModelUtils;

public class CreateMySqlJavaBeanService implements ICreateJavaBeanService {

    String host = "";
    String database = "";
    String user = "";
    String pass = "";
    String packname = "";
    String dirstr = "";
    String tablename = "";
    // local parameter
    String outputdir = "";
    private List<String> tablesList = new ArrayList();

    @Override
    public boolean validateInputParameters(SwingInputDto swingInputDto) {
        CommonUtils.setTips("【1/5】:Validating Input Parameters ......", swingInputDto);
        boolean returnFlag = false;
        host = swingInputDto.getStrIPValue().getText();
        database = swingInputDto.getStrDataBaseValue().getText();
        user = swingInputDto.getStrUserNameValue().getText();
        pass = swingInputDto.getStrPasswordValue().getText();
        packname = swingInputDto.getStrPackageNameValue().getText();
        dirstr = swingInputDto.getStrOutputPathValue().getText();// 空表示当前目录
        tablename = swingInputDto.getStrTableNameValue().getText();
        if (StringUtils.isBlank(host)) {
            CommonUtils.setTips("数据库IP必填", swingInputDto);
        } else if (StringUtils.isBlank(database)) {
            CommonUtils.setTips("数据库名[DataBase]必填", swingInputDto);
        } else if (StringUtils.isBlank(user)) {
            CommonUtils.setTips("数据库用户名[UserName]必填", swingInputDto);
        } else if (StringUtils.isBlank(pass)) {
            CommonUtils.setTips("数据库密码[Password]必填", swingInputDto);
        } else if (StringUtils.isBlank(packname)) {
            CommonUtils.setTips("包路径结构[Package Name]必填", swingInputDto);
        } else {
            returnFlag = true;
        }
        return returnFlag;
    }

    @Override
    public void prepareCreation(SwingInputDto swingInputDto) {
        CommonUtils.setTips("【2/5】:Preparing Creation ......", swingInputDto);

        // 1 #######################create folder#######################
        if (StringUtils.isBlank(dirstr)) {
            // 生成到当前路径
            FileSystemView fsv = FileSystemView.getFileSystemView();
            dirstr = fsv.getHomeDirectory().getAbsolutePath();
        }

        if (!dirstr.endsWith("/")) {
            dirstr += "/";
        }

        System.out.println("dirstr:" + dirstr);
        File modelDir = new File(dirstr + packname.replaceAll("\\.", "/") + Constants.STR_MODEL_PATH_SUFFIX);
        if (!modelDir.exists()) {
            modelDir.mkdirs();
        }
        File daoDir = new File(dirstr + packname.replaceAll("\\.", "/") + Constants.STR_DAO_PATH_SUFFIX);
        if (!daoDir.exists()) {
            daoDir.mkdirs();
        }
        File serviceDir = new File(dirstr + packname.replaceAll("\\.", "/") + Constants.STR_SERVICE_PATH_SUFFIX);
        if (!serviceDir.exists()) {
            serviceDir.mkdirs();
        }
        // for multiple Premary key
        File multiplePKDir = new File(dirstr + packname.replaceAll("\\.", "/") + Constants.STR_MODEL_PATH_MUTI_PK);
        if (!multiplePKDir.exists()) {
            multiplePKDir.mkdirs();
        }
        File tempDir = new File(dirstr + packname.replaceAll("\\.", "/"));
        outputdir = tempDir.getAbsolutePath();// bean的生成目录

        // get tablelist
        if (tablename.length() > 0) {
            // single table
            tablesList.add(tablename);
        } else {
            Connection conn = null;
            try {
                conn = DBManager.mysql(host, database, user, pass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                CommonUtils.setTips("找不到MySQL的jar包", swingInputDto);
            } catch (CommunicationsException e) {
                e.printStackTrace();
                System.out.println("e.getLocalizedMessage()￥#############" + e.getLocalizedMessage());
                CommonUtils.setTips(e.getLocalizedMessage(), swingInputDto);
            } catch (SQLException e) {
                e.printStackTrace();
                CommonUtils.setTips(e.getLocalizedMessage(), swingInputDto);
            }
            // multiple table
            String sql = "show tables";
            ResultSet rs = DBManager.query(conn, sql);
            try {
                while (rs.next()) {
                    tablesList.add(rs.getString(1));
                }
                DBManager.close(conn, null, rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 2 #######################query Table information#######################
        boolean createPackage = swingInputDto.getCheckBox().getSelectedObjects() != null;
        System.out.println(createPackage);

    }

    @Override
    public void createServiceCode(SwingInputDto swingInputDto) {
        // path: 1.packname+\services 2.packname+\services\impl
        for (String tableNameTemp : tablesList) {
            CommonUtils.setTips("【5/5】:Creating Service Code......" + tableNameTemp, swingInputDto);
            // init baseClass File eg:BaseA2CQTCONTRACT.java
            File serviceImplFile = new File(outputdir + Constants.STR_SERVICE_PATH_SUFFIX, MessageFormat.format(Constants.STR_BASEFILENAME_SERVICE,
                    CommonUtils.transClassName(tableNameTemp)));
            String serviceImplPackageInfo = MessageFormat.format(Constants.STR_BASEPACKAGEINFO_IMPL, packname + ".services");
            StringBuffer serviceImplImportInfo = new StringBuffer(Constants.STR_IMPORT_NAMED);
            serviceImplImportInfo.append(Constants.STR_IMPORT_INJECT);
            serviceImplImportInfo.append(Constants.STR_IMPORT_LOGGER);

            serviceImplImportInfo.append("import " + packname + ".services." + CommonUtils.transClassName(tableNameTemp) + "Service;\n");
            serviceImplImportInfo.append("import " + packname + ".dao." + CommonUtils.transClassName(tableNameTemp) + "Dao;\n");
            StringBuffer serviceImplClassInfo = new StringBuffer(CommonUtils.commentsInformation());
            serviceImplClassInfo.append(Constants.STR_BASE_CLASS_ANNOTATION_NAMED);

            serviceImplClassInfo.append(MessageFormat.format(Constants.STR_SERVICE_IMPL_CLASS, CommonUtils.transClassName(tableNameTemp)));
            serviceImplClassInfo.append("{ \n");
            serviceImplClassInfo.append(MessageFormat.format(Constants.STR_LOG, CommonUtils.transClassName(tableNameTemp)));

            serviceImplClassInfo.append(MessageFormat.format(Constants.STR_INJECT_DAO_INSERVICE,
                    CommonUtils.lowerFirestChar(CommonUtils.transClassName(tableNameTemp)), CommonUtils.transClassName(tableNameTemp)));

            serviceImplClassInfo.append("}\n\t");
            // init Class File
            File serviceFile = new File(outputdir + Constants.STR_SERVICE_PATH, MessageFormat.format(Constants.STR_FILENAME_SERVICE,
                    CommonUtils.transClassName(tableNameTemp)));
            String servicePackageinfo = MessageFormat.format(Constants.STR_PACKAGEINFO, packname + ".services");
            StringBuffer serviceImportInfo = new StringBuffer();

            StringBuffer serviceClassInfo = new StringBuffer(CommonUtils.commentsInformation());
            serviceClassInfo.append(MessageFormat.format(Constants.STR_SERVICE_CLASS, CommonUtils.transClassName(tableNameTemp)));
            serviceClassInfo.append("{ \n}\n\t");

            // write File
            CommonUtils.writeFile(serviceImplFile, serviceImplPackageInfo, serviceImplImportInfo.toString(), serviceImplClassInfo.toString());
            CommonUtils.writeFile(serviceFile, servicePackageinfo, serviceImportInfo.toString(), serviceClassInfo.toString());
        }
    }

    @Override
    public void createDaoCode(SwingInputDto swingInputDto) {
        // path:1.packname+\db\dao 2.packname+\db\dao\impl
        for (String tableNameTemp : tablesList) {
            CommonUtils.setTips("【4/5】:Creating Dao Code ......" + tableNameTemp, swingInputDto);
            // init baseClass File eg:BaseA2CQTCONTRACT.java
            File implFile = new File(outputdir + Constants.STR_DAO_PATH_SUFFIX, MessageFormat.format(Constants.STR_BASEFILENAME_DAO,
                    CommonUtils.transClassName(tableNameTemp)));
            String implPackageInfo = MessageFormat.format(Constants.STR_BASEPACKAGEINFO_IMPL, packname + ".dao");
            StringBuffer implImportInfo = new StringBuffer(Constants.STR_IMPORT_NAMED);
            implImportInfo.append(Constants.STR_IMPORT_GENERICHIBERNATEDAO);
            implImportInfo.append("import " + packname + ".db." + CommonUtils.transClassName(tableNameTemp) + ";\n");
            implImportInfo.append("import " + packname + ".dao." + CommonUtils.transClassName(tableNameTemp) + "Dao;\n");

            StringBuffer daoImplClassInfo = new StringBuffer(CommonUtils.commentsInformation());
            daoImplClassInfo.append(Constants.STR_BASE_CLASS_ANNOTATION_NAMED);
            // ToDo add PK
            daoImplClassInfo.append(MessageFormat.format(Constants.STR_DAO_IMPL_CLASS, CommonUtils.transClassName(tableNameTemp)));
            daoImplClassInfo.append("{ \n}\n\t");
            // init Class File
            File daoFile = new File(outputdir + Constants.STR_DAO_PATH, MessageFormat.format(Constants.STR_FILENAME_DAO,
                    CommonUtils.transClassName(tableNameTemp)));
            String daoPackageinfo = MessageFormat.format(Constants.STR_PACKAGEINFO, packname + ".dao");
            StringBuffer daoImportInfo = new StringBuffer(Constants.STR_IMPORT_GENERICDAO);
            daoImportInfo.append("import " + packname + ".db." + CommonUtils.transClassName(tableNameTemp) + ";\n");

            StringBuffer daoClassInfo = new StringBuffer();
            daoClassInfo.append(MessageFormat.format(Constants.STR_DAO_CLASS, CommonUtils.transClassName(tableNameTemp)));
            daoClassInfo.append("{ \n}\n\t");

            CommonUtils.writeFile(implFile, implPackageInfo, implImportInfo.toString(), daoImplClassInfo.toString());

            CommonUtils.writeFile(daoFile, daoPackageinfo, daoImportInfo.toString(), daoClassInfo.toString());
        }

    }

    @Override
    public void createModelCode(SwingInputDto swingInputDto) {
        // path:1.packname+\db\model 2.packname+\db\model\base

        Connection conn = null;
        try {
            conn = DBManager.mysql(host, database, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            CommonUtils.setTips("找不到MySQL的jar包", swingInputDto);
        } catch (SQLException e) {
            e.printStackTrace();
            CommonUtils.setTips(e.getLocalizedMessage(), swingInputDto);
        }

        try {
            for (String tableNameTemp : tablesList) {
                CommonUtils.setTips("【3/5】:Creating Model Code ......" + tableNameTemp, swingInputDto);
                singleTableModelCreation(conn, tableNameTemp, packname + ".db", outputdir);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, null, null);
        }

        System.out.println("#############END#################");

    }

    private void singleTableModelCreation(Connection conn, String tablename, String packname, String outputdir) {
        // query unique index
        List<IndexInformation> indexList = new ArrayList();
        String queryIndexSql = "show index from " + tablename + " where non_unique=0 ";
        ResultSet rs = null;
        try {
            rs = DBManager.query(conn, queryIndexSql);
            List<IndexInformation> pkIndexList = new ArrayList();
            List<IndexInformation> uniqueIndexList = new ArrayList();

            while (rs.next()) {
                IndexInformation indexInformation = new IndexInformation();
                indexInformation.setKeyName(rs.getString(3));
                indexInformation.setColumnName(rs.getString(5));

                if (StringUtils.equals("PRIMARY", indexInformation.getKeyName())) {
                    pkIndexList.add(indexInformation);
                } else {
                    uniqueIndexList.add(indexInformation);
                }
            }
            if (uniqueIndexList.size() > 0) {
                indexList.addAll(uniqueIndexList);
            } else {
                indexList.addAll(pkIndexList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // query Fields for single Table
        List<FieldInformation> fieldsList = new ArrayList();
        String queryFieldsSql = "select t.ORDINAL_POSITION,t.COLUMN_NAME,t.DATA_TYPE,t.CHARACTER_MAXIMUM_LENGTH,t.COLUMN_DEFAULT from information_schema.columns t where t.table_name='"
                + tablename + "' ";
        rs = null;
        try {
            rs = DBManager.query(conn, queryFieldsSql);

            while (rs.next()) {
                FieldInformation fieldInformationTemp = new FieldInformation();
                fieldInformationTemp.setOrdinalPosition(rs.getString(1));
                fieldInformationTemp.setColumnName(rs.getString(2));
                fieldInformationTemp.setDataType(rs.getString(3));
                fieldInformationTemp.setCharacterMaximumLength(rs.getString(4));
                fieldInformationTemp.setColumnDefault(rs.getString(5));
                System.out.println(fieldInformationTemp.toString());
                fieldsList.add(fieldInformationTemp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // query pk and fk for single Table
        List<PremaryKeyAndForeignKeyInformation> primaryKeyList = new ArrayList();
        List<PremaryKeyAndForeignKeyInformation> foreignKeyList = new ArrayList();

        String queryPKAndFKSql = "select TABLE_NAME,COLUMN_NAME,CONSTRAINT_NAME, REFERENCED_TABLE_NAME,REFERENCED_COLUMN_NAME from INFORMATION_SCHEMA.KEY_COLUMN_USAGE where TABLE_NAME='"
                + tablename + "'";
        try {
            rs = DBManager.query(conn, queryPKAndFKSql);
            while (rs.next()) {
                PremaryKeyAndForeignKeyInformation keyInformation = new PremaryKeyAndForeignKeyInformation();
                keyInformation.setTableName(rs.getString(1));
                keyInformation.setColumnName(rs.getString(2));
                keyInformation.setConstraintName(rs.getString(3));
                keyInformation.setReferencedTableName(rs.getString(4));
                keyInformation.setReferencedColumnName(rs.getString(5));

                System.out.println(keyInformation.toString());

                if ("PRIMARY".equals(keyInformation.getConstraintName())) {
                    primaryKeyList.add(keyInformation);
                } else if (StringUtils.isNotEmpty(keyInformation.getReferencedTableName())) {
                    foreignKeyList.add(keyInformation);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(false ? conn : null, null, rs);
        }
        if (primaryKeyList.size() > 1) {
            // ###########Multiple Primary Key###########
            List<FieldInformation> pkFieldsList = new ArrayList();
            Set<FieldInformation> remainFieldsList = new HashSet();
            boolean addReamin;
            for (FieldInformation fieldInfoTemp : fieldsList) {
                addReamin = true;
                for (PremaryKeyAndForeignKeyInformation pkInfoTemp : primaryKeyList) {
                    if (StringUtils.equals(fieldInfoTemp.getColumnName(), pkInfoTemp.getColumnName())) {
                        pkFieldsList.add(fieldInfoTemp);
                        addReamin = false;
                    }
                }
                if (addReamin) {
                    remainFieldsList.add(fieldInfoTemp);
                }
            }

            String multiplePKClassName = ModelUtils.createMultiplePremaryKeyClass(outputdir, packname, tablename, pkFieldsList, indexList);

            // init baseClass File eg:BaseA2CQTCONTRACT.java
            File baseFile = new File(outputdir + Constants.STR_MODEL_PATH_SUFFIX, MessageFormat.format(Constants.STR_BASEFILENAME,
                    CommonUtils.transClassName(tablename)));
            String basePackageInfo = MessageFormat.format(Constants.STR_BASEPACKAGEINFO, packname);
            StringBuffer baseImportInfo = new StringBuffer(Constants.STR_IMPORT_MAPPEDSUPERCLASS);
            baseImportInfo.append(Constants.STR_IMPORT_SERIALIZABLE);
            baseImportInfo.append(Constants.STR_IMPORT_EMBEDDEDID);

            StringBuffer baseClassInfo = new StringBuffer(CommonUtils.commentsInformation());
            baseClassInfo.append(Constants.STR_BASE_CLASS_ANNOTATION);
            baseClassInfo.append("public class Base").append(CommonUtils.transClassName(tablename)).append(" implements Serializable {\r\n");
            StringBuffer basePropFields = new StringBuffer(Constants.STR_SERIAL_VERSION_UID_BASECLASS);

            StringBuffer baseFields = new StringBuffer();
            StringBuffer baseMethods = new StringBuffer();
            // add multiplePremaryKey base fields and Methods Begin
            baseFields.append(MessageFormat.format(Constants.STR_MULTIPLEPREMARYKEY_BASEFIELD, multiplePKClassName));
            baseMethods.append(ModelUtils.getMethodStr("id", multiplePKClassName));
            baseImportInfo.append("import " + packname + ".premary." + multiplePKClassName + ";\n");
            // add multiplePremaryKey base fields and Methods End
            // init Class File
            File file = new File(outputdir + Constants.STR_MODEL_PATH, MessageFormat.format(Constants.STR_FILENAME,
                    CommonUtils.transClassName(tablename)));
            String packageinfo = MessageFormat.format(Constants.STR_PACKAGEINFO, packname);
            StringBuffer importInfo = new StringBuffer(Constants.STR_IMPORT_ENTITY + Constants.STR_IMPORT_TABLE);
            importInfo.append("import " + packname + ".base.Base" + CommonUtils.transClassName(tablename) + ";\n");
            StringBuffer classInfo = new StringBuffer(Constants.STR_CLASS_ANNOTATION_ENTITY);
            classInfo.append(MessageFormat.format(Constants.STR_CLASS_ANNOTATION_TABLE, tablename));
            classInfo.append("public class ").append(CommonUtils.transClassName(tablename)).append(" extends Base")
                    .append(CommonUtils.transClassName(tablename)).append("{\r\n\n");
            classInfo.append(Constants.STR_SERIAL_VERSION_UID_MAINCLASS);
            // create BaseClass Inofrmation contains 3 parts:
            Set<String> importList = new HashSet();
            for (FieldInformation fieldInformationTemp : remainFieldsList) {
                boolean isForeignKey = false;
                // ####part 1: basePropFields####
                basePropFields.append(MessageFormat.format(Constants.STR_BASE_CLASEINFOR_PROP_FIELD, fieldInformationTemp.getColumnName(),
                        ModelUtils.fieldTrans(fieldInformationTemp.getColumnName())));

                // ####part 2: baseFields####
                PremaryKeyAndForeignKeyInformation specialKeyInformation = ModelUtils.validSpecialKey(fieldInformationTemp.getColumnName(),
                        primaryKeyList, foreignKeyList);
                System.out.println("specialKeyInformation:" + specialKeyInformation);
                if (specialKeyInformation == null) {
                    // for the common field
                    baseFields.append(ModelUtils.getFieldStr(fieldInformationTemp.getColumnName(),
                            ModelUtils.typeTrans(fieldInformationTemp.getDataType(), importList), fieldInformationTemp.getColumnDefault()));
                    importList.add(Constants.STR_IMPORT_COLUMN);

                } else {
                    // there is no PK key
                    if (StringUtils.equals(Constants.STR_FOREIGN_KEY, specialKeyInformation.getSpecialKey())) {
                        // for the Foreign Key
                        baseFields.append(ModelUtils.getFieldStrForeignKey(fieldInformationTemp.getColumnName(),
                                CommonUtils.transClassName(specialKeyInformation.getReferencedTableName()), importList));
                        importList.add("import " + packname + "." + CommonUtils.transClassName(specialKeyInformation.getReferencedTableName())
                                + ";\n");
                        isForeignKey = true;
                    }

                }
                // ####part 3: baseMethods####
                if (isForeignKey) {
                    baseMethods.append(ModelUtils.getMethodStr(fieldInformationTemp.getColumnName(),
                            CommonUtils.transClassName(specialKeyInformation.getReferencedTableName())));
                } else {
                    baseMethods.append(ModelUtils.getMethodStr(fieldInformationTemp.getColumnName(),
                            ModelUtils.typeTrans(fieldInformationTemp.getDataType(), importList)));
                }
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
            CommonUtils.writeFile(baseFile, basePackageInfo, baseImportInfo.toString(), baseClassInfo.toString());

            classInfo.append("\r\n");
            classInfo.append("}");
            CommonUtils.writeFile(file, packageinfo, importInfo.toString(), classInfo.toString());

        } else {
            // ###########single Primary Key###########
            // String primaryKeyField = primaryKeyList.get(0).getColumnName();

            // init baseClass File eg:BaseA2CQTCONTRACT.java
            File baseFile = new File(outputdir + Constants.STR_MODEL_PATH_SUFFIX, MessageFormat.format(Constants.STR_BASEFILENAME,
                    CommonUtils.transClassName(tablename)));
            String basePackageInfo = MessageFormat.format(Constants.STR_BASEPACKAGEINFO, packname);
            StringBuffer baseImportInfo = new StringBuffer(Constants.STR_IMPORT_MAPPEDSUPERCLASS);
            baseImportInfo.append(Constants.STR_IMPORT_SERIALIZABLE);
            StringBuffer baseClassInfo = new StringBuffer(CommonUtils.commentsInformation());
            baseClassInfo.append(Constants.STR_BASE_CLASS_ANNOTATION);
            baseClassInfo.append("public class Base").append(CommonUtils.transClassName(tablename)).append(" implements Serializable {\r\n");
            StringBuffer basePropFields = new StringBuffer(Constants.STR_SERIAL_VERSION_UID_BASECLASS);
            if (indexList.size() > 0) {
                basePropFields.append(Constants.STR_HASHCODEBUILDER);
            }
            StringBuffer baseFields = new StringBuffer();
            StringBuffer baseMethods = new StringBuffer();
            // init Class File
            File file = new File(outputdir + Constants.STR_MODEL_PATH, MessageFormat.format(Constants.STR_FILENAME,
                    CommonUtils.transClassName(tablename)));
            String packageinfo = MessageFormat.format(Constants.STR_PACKAGEINFO, packname);
            StringBuffer importInfo = new StringBuffer(Constants.STR_IMPORT_ENTITY + Constants.STR_IMPORT_TABLE);
            importInfo.append("import " + packname + ".base.Base" + CommonUtils.transClassName(tablename) + ";\n");
            StringBuffer classInfo = new StringBuffer(Constants.STR_CLASS_ANNOTATION_ENTITY);
            classInfo.append(MessageFormat.format(Constants.STR_CLASS_ANNOTATION_TABLE, tablename));
            classInfo.append("public class ").append(CommonUtils.transClassName(tablename)).append(" extends Base")
                    .append(CommonUtils.transClassName(tablename)).append("{\r\n\n");
            classInfo.append(Constants.STR_SERIAL_VERSION_UID_MAINCLASS);
            // create BaseClass Inofrmation contains 3 parts:
            Set<String> importList = new HashSet();
            for (FieldInformation fieldInformationTemp : fieldsList) {
                boolean isForeignKey = false;
                // ####part 1: basePropFields####
                basePropFields.append(MessageFormat.format(Constants.STR_BASE_CLASEINFOR_PROP_FIELD, fieldInformationTemp.getColumnName(),
                        ModelUtils.fieldTrans(fieldInformationTemp.getColumnName())));

                // ####part 2: baseFields####
                PremaryKeyAndForeignKeyInformation specialKeyInformation = ModelUtils.validSpecialKey(fieldInformationTemp.getColumnName(),
                        primaryKeyList, foreignKeyList);
                System.out.println("specialKeyInformation:" + specialKeyInformation);
                if (specialKeyInformation == null) {
                    // for the common field
                    baseFields.append(ModelUtils.getFieldStr(fieldInformationTemp.getColumnName(),
                            ModelUtils.typeTrans(fieldInformationTemp.getDataType(), importList), fieldInformationTemp.getColumnDefault()));
                    importList.add(Constants.STR_IMPORT_COLUMN);

                } else {
                    if (StringUtils.equals(Constants.STR_PRIMARY_KEY, specialKeyInformation.getSpecialKey())) {
                        // for the PrimaryKey
                        baseFields.append(ModelUtils.getFieldStrPrimaryKey(fieldInformationTemp.getColumnName(),
                                ModelUtils.typeTrans(fieldInformationTemp.getDataType(), importList), tablename, importList));
                    } else {
                        // for the Foreign Key
                        baseFields.append(ModelUtils.getFieldStrForeignKey(fieldInformationTemp.getColumnName(),
                                CommonUtils.transClassName(specialKeyInformation.getReferencedTableName()), importList));
                        importList.add("import " + packname + "." + CommonUtils.transClassName(specialKeyInformation.getReferencedTableName())
                                + ";\n");
                        isForeignKey = true;
                    }

                }
                // ####part 3: baseMethods####
                if (isForeignKey) {
                    baseMethods.append(ModelUtils.getMethodStr(fieldInformationTemp.getColumnName(),
                            CommonUtils.transClassName(specialKeyInformation.getReferencedTableName())));
                } else {
                    baseMethods.append(ModelUtils.getMethodStr(fieldInformationTemp.getColumnName(),
                            ModelUtils.typeTrans(fieldInformationTemp.getDataType(), importList)));
                }
            }

            // add two method in BaseClase: HashCode() and equals();
            if (indexList.size() > 0) {
                baseMethods.append(ModelUtils.getOverwriteHashCodeAndEquals(indexList, "Base" + CommonUtils.transClassName(tablename), importList));
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
            CommonUtils.writeFile(baseFile, basePackageInfo, baseImportInfo.toString(), baseClassInfo.toString());

            classInfo.append("\r\n");
            classInfo.append("}");
            CommonUtils.writeFile(file, packageinfo, importInfo.toString(), classInfo.toString());
        }

    }

}
