package site.lifd.core.crypto;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.UndeclaredThrowableException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

/**
 * TOTP 算法
 *
 * @author lifengdi
 * @createTime 2024/12/2 18:05
 */
public class TOTP {
    private TOTP() {
    }

    /**
     * 获取 TOTP
     *
     * @param key 密钥
     * @return TOTP
     */
    public static String getOTP(String key) {
        return getOTP(getStep(), key);
    }

    /**
     * 校验 TOTP
     *
     * @param key 密钥
     * @param otp 待校验的 TOTP
     * @return 校验结果
     */
    public static boolean validate(String key, String otp) {
        return validate(getStep(), key, otp);
    }

    /**
     * 校验 TOTP
     *
     * @param step 步长
     * @param key  密钥
     * @param otp  待校验的 TOTP
     * @return 校验结果
     */
    private static boolean validate(long step, String key, String otp) {
        return getOTP(step, key).equals(otp) || getOTP(step - 1L, key).equals(otp);
    }

    /**
     * 获取当前 TOTP 步长
     *
     * @return 步长
     */
    private static long getStep() {
        return System.currentTimeMillis() / 30000L;
    }

    /**
     * 获取 TOTP
     *
     * @param step 步长
     * @param key  密钥
     * @return TOTP
     */
    private static String getOTP(long step, String key) {
        String steps;
        for(steps = Long.toHexString(step).toUpperCase(); steps.length() < 16; steps = "0" + steps) {
        }

        byte[] msg = hexStr2Bytes(steps);
        byte[] k = hexStr2Bytes(key);
        byte[] hash = hmac_sha1(k, msg);
        int offset = hash[hash.length - 1] & 15;
        int binary = (hash[offset] & 127) << 24 | (hash[offset + 1] & 255) << 16 | (hash[offset + 2] & 255) << 8 | hash[offset + 3] & 255;
        int otp = binary % 1000000;

        String result;
        for(result = Integer.toString(otp); result.length() < 6; result = "0" + result) {
        }

        return result;
    }

    /**
     * 将16进制字符串转换成字节数组
     *
     * @param hex 16进制字符串
     * @return 字节数组
     */
    private static byte[] hexStr2Bytes(String hex) {
        byte[] bArray = (new BigInteger("10" + hex, 16)).toByteArray();
        byte[] ret = new byte[bArray.length - 1];
        System.arraycopy(bArray, 1, ret, 0, ret.length);
        return ret;
    }

    /**
     * HMAC-SHA1
     *
     * @param keyBytes 密钥
     * @param text     待加密内容
     * @return 加密结果
     */
    private static byte[] hmac_sha1(byte[] keyBytes, byte[] text) {
        try {
            Mac hmac = Mac.getInstance("HmacSHA1");
            SecretKeySpec macKey = new SecretKeySpec(keyBytes, "RAW");
            hmac.init(macKey);
            return hmac.doFinal(text);
        } catch (GeneralSecurityException var4) {
            GeneralSecurityException gse = var4;
            throw new UndeclaredThrowableException(gse);
        }
    }
}
