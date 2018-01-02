package cn.com.omo.infrastructure.common.constant;

import java.util.Locale;


/**
 * 通用常量
 * @date 2017年12月27日
 * 
 * @author zhihong.he
 * @version 
 * @since 1.0
  */
public class CommonConstants {

    /* charset name */
    public static final String UTF_8_CHARSET_NAME = "UTF-8";
    public static final String GBK_CHARSET_NAME = "GBK";
    public static final String ISO_CHARSET_NAME = "ISO-8859-1";

    /* SYMBOL */
    public static final String EMPTY_STR = "";
    public static final String BLANK = " ";
    public static final String SPACE = " ";
    public static final String BANG = "!";
    public static final String QUESTION_MARK = "?";
    public static final String COMMA = ",";
    public static final String POINT = ".";
    public static final String COLON = ":";
    public static final String SEMICOLON = ";";
    public static final String QUOTE = "'";
    public static final String SINGLE_QUOTE = "\'";
    public static final String DOUBLE_QUOTE = "\"";
    public static final String STAR = "*";
    public static final String PLUS = "+";
    public static final String DASH = "-";
    public static final String EQUAL = "=";
    public static final String SLASH = "/";
    public static final String BACK_SLASH = "\\";
    public static final String PIPE = "|";
    public static final String ESCAPE_PIPE = BACK_SLASH + PIPE;
    public static final String THREE_PIPE = "|||";
    public static final String UNDERLINE = "_";
    public static final String DOLOR = "$";
    public static final String AT = "@";
    public static final String CROSS_HATCH = "#";
    public static final String PERCENT = "%";
    public static final String AND = "&";
    public static final String CIRCUMFLEX = "^";
    public static final String TILDE = "~";
    public static final String LEFT_BRACE = "{";
    public static final String RIGHT_BRACE = "}";
    public static final String LEFT_BRACKET = "[";
    public static final String RIGHT_BRACKET = "]";
    public static final String LEFT_ANGLE_BRACKET = "<";
    public static final String RIGHT_ANGLE_BRACKET = ">";
    public static final String LEFT_PARENTHESES = "(";
    public static final String RIGHT_PARENTHESES = ")";

    public static final String LINE_CHANGE_SYMBOL = "\n";
    public static final String ENTER_SYMBOL = "\r";
    public static final String CLASSPATH_PREFIX = "classpath:";
    public static final String PROPERTIES_SUFFIX = ".properties";
    public static final String CLASS_SUFFIX = ".class";

    /* LOCALE */
    public static final String[] ALL_LOCALES_STRING = { Locale.ENGLISH.toString(), Locale.FRENCH.toString(),
            Locale.GERMAN.toString(), Locale.ITALIAN.toString(), Locale.JAPANESE.toString(), Locale.KOREAN.toString(),
            Locale.CHINESE.toString(), Locale.SIMPLIFIED_CHINESE.toString(), Locale.TRADITIONAL_CHINESE.toString(),
            Locale.FRANCE.toString(), Locale.GERMANY.toString(), Locale.ITALY.toString(), Locale.JAPAN.toString(),
            Locale.KOREA.toString(), Locale.CHINA.toString(), Locale.PRC.toString(), Locale.TAIWAN.toString(),
            Locale.UK.toString(), Locale.US.toString(), Locale.CANADA.toString(), Locale.CANADA_FRENCH.toString()

    };
}
