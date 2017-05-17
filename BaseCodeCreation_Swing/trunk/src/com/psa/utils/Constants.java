/*
 * Creation : Nov 7, 2016
 */
package com.psa.utils;

public class Constants {

    public static final String STR_CLASS_ANNOTATION_ENTITY = "\n@Entity \n";
    public static final String STR_CLASS_ANNOTATION_TABLE = "@Table(name = \"{0}\") \n";
    public static final String STR_CLASS_ANNOTATION_EMBEDDABLE = "@Embeddable \n";
    public static final String STR_BASE_CLASS_ANNOTATION = "@MappedSuperclass \n";
    public static final String STR_BASE_CLASS_ANNOTATION_NAMED = "@Named \n";

    public static final String STR_FIELD_ANNOTATION_COLUMN = "\n\t@Column(name = \"{0}\") \n";
    // allocationSize = Constants.PK_BZ_ALLOCATION_SIZE, initialValue = Constants.PK_BZ_INITIAL_VALUE
    public static final String STR_FIELD_ANNOTATION_SINGLE_PK = "\n\t@Id\n\t@TableGenerator(name = \"{0}_GEN\", table = \"SFJQTPKGEN\", pkColumnName = \"GEN_NAME\", pkColumnValue = \"{0}_PK\", valueColumnName = \"GEN_VAL\", allocationSize = 100000, initialValue = 10000)\n\t@GeneratedValue(strategy = GenerationType.TABLE, generator = \"{0}_GEN\")\n";

    public static final String STR_FIELD_ANNOTATION_FK = "\n\t@ManyToOne\n\t@JoinColumn(name = \"{0}\")\n";

    public static final String STR_IMPORT_ENTITY = "import javax.persistence.Entity; \n";
    public static final String STR_IMPORT_TABLE = "import javax.persistence.Table; \n";

    public static final String STR_IMPORT_Id = "import javax.persistence.Id;\n";
    public static final String STR_IMPORT_GeneratedValue = "import javax.persistence.GeneratedValue;\n";
    public static final String STR_IMPORT_GenerationType = "import javax.persistence.GenerationType;\n";
    public static final String STR_IMPORT_TableGenerator = "import javax.persistence.TableGenerator;\n";

    public static final String STR_IMPORT_JOINCOLUMN = "import javax.persistence.JoinColumn;\n";
    public static final String STR_IMPORT_MANYTOONE = "import javax.persistence.ManyToOne;\n";

    public static final String STR_IMPORT_EQUALSBUILDER = "import org.apache.commons.lang3.builder.EqualsBuilder;\n";
    public static final String STR_IMPORT_HASHCODEBUILDER = "import org.apache.commons.lang3.builder.HashCodeBuilder;\n";

    public static final String STR_IMPORT_EMBEDDABLE = "import javax.persistence.Embeddable;\n";
    public static final String STR_IMPORT_EMBEDDEDID = "import javax.persistence.EmbeddedId;\n";

    public static final String STR_IMPORT_MAPPEDSUPERCLASS = "import javax.persistence.MappedSuperclass;\n";
    public static final String STR_IMPORT_SERIALIZABLE = "import java.io.Serializable;\n";
    public static final String STR_IMPORT_BIGDECIMAL = "import java.math.BigDecimal;\n";
    public static final String STR_IMPORT_DATE = "import java.util.Date;\n";
    public static final String STR_IMPORT_COLUMN = "import javax.persistence.Column;\n";
    public static final String STR_IMPORT_ID = "import javax.persistence.Id;\n";
    public static final String STR_IMPORT_ONETOONE = "import javax.persistence.OneToOne;\n";

    public static final String STR_IMPORT_NAMED = "import javax.inject.Named;\n";
    public static final String STR_IMPORT_INJECT = "import javax.inject.Inject;\n";
    public static final String STR_IMPORT_GENERICHIBERNATEDAO = "import com.inetpsa.sfj.db.dao.GenericHibernateDao;\n";
    public static final String STR_IMPORT_GENERICDAO = "import com.inetpsa.sfj.db.dao.GenericDao;\n";
    public static final String STR_IMPORT_LOGGER = "import org.slf4j.Logger;\nimport org.slf4j.LoggerFactory;\n";

    public static final String STR_MUTI_PK_PACKAGEINFO = "package {0}.premary;  \n \n";
    public static final String STR_BASEPACKAGEINFO = "package {0}.base;  \n \n";
    public static final String STR_PACKAGEINFO = "package {0};  \n \n";

    public static final String STR_BASEPACKAGEINFO_IMPL = "package {0}.impl;  \n \n";

    public static final String STR_BASEFILENAME = "Base{0}.java";
    public static final String STR_FILENAME = "{0}.java";

    public static final String STR_BASEFILENAME_DAO = "{0}DaoImpl.java";
    public static final String STR_FILENAME_DAO = "{0}Dao.java";

    public static final String STR_BASEFILENAME_SERVICE = "{0}ServiceImpl.java";
    public static final String STR_FILENAME_SERVICE = "{0}Service.java";

    public static final String STR_LOG = "\n \t /** The log. */ \n \tprivate static final Logger LOG = LoggerFactory.getLogger({0}ServiceImpl.class);\n";

    public static final String STR_INJECT_DAO_INSERVICE = "\n \t/** The {0} dao. */\n \t@Inject \n \tprivate {1}Dao {0}Dao; \n";

    public static final String STR_CONSTANT_FIELD = " \t public static final String {0}Field = \"{1}\"; \n";

    public static final String STR_BASE_CLASEINFOR_PROP_FIELD = "\t /** The Constant PROP_{0}. */ \n \t public static final String PROP_{0} = \"{1}\"; \n\n";

    public static final String STR_SERIAL_VERSION_UID_BASECLASS = "\n \t /** The Constant serialVersionUID. */ \n \t  private static final long serialVersionUID = 1L; \n";

    public static final String STR_SERIAL_VERSION_UID_MAINCLASS = "\n \t /** serialVersionUID. */ \n \t  private static final long serialVersionUID = 4757670355232062105L; \n";

    public static final String STR_MULTIPLEPREMARYKEY_BASEFIELD = "\n\t/** The id. */\n\t@EmbeddedId\n\tprivate {0} id;\n";

    public static final String STR_HASHCODEBUILDER = "\n \t /** The Constant hashBuilder. */\n \t  public static final HashCodeBuilder HASH_BUILDER = new HashCodeBuilder(53, 179); \n\n";

    public static final String STR_BASECLASS_METHOD_HASHCODE = "\n\t\treturn HASH_BUILDER{0}.toHashCode();\n\t";

    public static final String STR_BASECLASS_METHOD_EQUALS = "\n\t        {0} other = ({0}) obj;\n\t        return new EqualsBuilder(){1}.isEquals();\n\t    ";

    public static final String STR_PRIMARY_KEY = "primaryKey";
    public static final String STR_FOREIGN_KEY = "foreignKey";

    public static final String STR_BATCH_STATUS_SUCCESS = "success";

    public static final String STR_MODEL_PATH = "/db";
    public static final String STR_MODEL_PATH_MUTI_PK = "/db/premary";
    public static final String STR_MODEL_PATH_SUFFIX = "/db/base";
    public static final String STR_DAO_PATH = "/dao";

    public static final String STR_DAO_PATH_SUFFIX = "/dao/impl";

    public static final String STR_SERVICE_PATH = "/services";
    public static final String STR_SERVICE_PATH_SUFFIX = "/services/impl";

    public static final String STR_DAO_IMPL_CLASS = "public class {0}DaoImpl extends GenericHibernateDao<{0}, Long> implements {0}Dao ";

    public static final String STR_DAO_CLASS = "public interface {0}Dao extends GenericDao<{0}, Long>  ";

    public static final String STR_SERVICE_IMPL_CLASS = "public class {0}ServiceImpl  implements {0}Service ";

    public static final String STR_SERVICE_CLASS = "public interface {0}Service ";

}
