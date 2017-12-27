package cn.com.omo.infrastructure.common.util;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;

import cn.com.omo.infrastructure.common.constant.CommonConstants;

/**
 *
 * @date 2017年12月27日
 * 
 * @author zhihong.he
 * @version
 * @since 1.0
 */
public class EncodingUtils {

    private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
            'E', 'F' };

    private static final String MD5 = "MD5";
    private static final String SHA_1 = "SHA-1";
    private static final String DESEDE = "DESede";
    private static final String DESEDE_CIPHER = "DESede/ECB/PKCS5Padding";

    /**
     * des加密key
     */
    private static final String DEFAULT_DES_KEY = "^h$_0j9kwf$y7,@w%;o+f[]-";

    /**
     * MD5加密
     * 
     * @param plaintext（明文字符串）
     * @return 密文字符串
     */
    public static String encodeByMD5(String plaintext) {
        return encode(plaintext, MD5);
    }

    /**
     * sha加密
     * 
     * @param plaintext（明文字符串）
     * @return 密文字符串
     */
    public static String encodeBySha1(String plaintext) {
        return encode(plaintext, SHA_1);
    }

    private static String encode(String plaintext, String algorithm) {
        try {
            byte[] btInput = plaintext.getBytes(CommonConstants.UTF_8_CHARSET_NAME);

            // 获得摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance(algorithm);

            // 使用指定的字节更新摘要
            mdInst.update(btInput);

            // 获得密文
            byte[] md = mdInst.digest();

            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = HEX_DIGITS[byte0 >>> 4 & 0xf];
                str[k++] = HEX_DIGITS[byte0 & 0xf];
            }

            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * DES加密
     * 
     * @param plaintext（明文字符串）
     * @return 密文字符串
     * @throws Exception
     */
    public static String encodeByDESECB(String plaintext) {
        try {
            DESedeKeySpec dks = new DESedeKeySpec(DEFAULT_DES_KEY.getBytes(CommonConstants.UTF_8_CHARSET_NAME));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DESEDE);
            SecretKey securekey = keyFactory.generateSecret(dks);

            Cipher cipher = Cipher.getInstance(DESEDE_CIPHER);
            cipher.init(Cipher.ENCRYPT_MODE, securekey);

            return Base64.encodeBase64String(cipher.doFinal(plaintext.getBytes(CommonConstants.UTF_8_CHARSET_NAME)))
                    .replaceAll(CommonConstants.ENTER_SYMBOL, "").replaceAll(CommonConstants.LINE_CHANGE_SYMBOL, "");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 字符串转换为Ascii
     * 
     * @param value
     * @return
     */
    public static String string2Ascii(String value) {
        StringBuilder sbu = new StringBuilder();

        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sbu.append((int) chars[i]).append(",");
        }

        return sbu.substring(0, sbu.length() - 1);
    }
}
