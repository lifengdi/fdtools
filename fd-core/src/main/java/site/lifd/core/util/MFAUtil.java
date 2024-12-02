package site.lifd.core.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import site.lifd.core.crypto.TOTP;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * MFA工具类
 *
 * @author lifengdi
 * @createTime 2024/12/2 19:43
 */
public class MFAUtil {

    /**
     * 生成32位的密钥
     *
     * @return 密钥
     */
    public static String generateSecretKey() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        Base32 base32 = new Base32();
        return base32.encodeToString(bytes);
    }

    /**
     * 获取TOTP验证码
     *
     * @param secretKey 密钥
     * @return TOTP验证码
     */
    public static String getTOTPCode(String secretKey) {
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(secretKey);
        String hexKey = Hex.encodeHexString(bytes);
        return TOTP.getOTP(hexKey);
    }

    /**
     * 生成二维码内容字符串
     *
     * @param account   账户信息（展示在Google Authenticator App中的）
     * @param secretKey 密钥
     * @param title     标题 （展示在Google Authenticator App中的）
     * @return 二维码内容字符串
     */
    public static String generateScanQRString(String account, String secretKey, String title) {
        return "otpauth://totp/"
                + URLEncoder.encode(title + ":" + account, StandardCharsets.UTF_8).replace("+", "%20")
                + "?secret=" + URLEncoder.encode(secretKey, StandardCharsets.UTF_8).replace("+", "%20")
                + "&issuer=" + URLEncoder.encode(title, StandardCharsets.UTF_8).replace("+", "%20");
    }

    /**
     * 生成二维码图片
     *
     * @param account   账户信息（展示在Google Authenticator App中的）
     * @param secretKey 密钥
     * @param title     标题 （展示在Google Authenticator App中的）
     * @return 二维码图片base64
     * @throws WriterException 编码异常
     * @throws IOException     IO异常
     */
    public static String generateQRCode(String account, String secretKey, String title) throws WriterException, IOException {
        String barCodeData = generateScanQRString(account, secretKey, title);
        return createQRCode(barCodeData, null, 300, 300);
    }

    public static void main(String[] args) throws IOException, WriterException {
        String secretKey = generateSecretKey();
        System.out.println("密钥：" + secretKey);
        System.out.println("二维码：" + generateQRCode("admin", secretKey, "DineroTree"));
    }

    /**
     * 生成二维码图片
     *
     * @param barCodeData 二维码内容
     * @param outPath     二维码图片输出路径
     * @param height      二维码图片高度
     * @param width       二维码图片宽度
     * @return 二维码图片base64
     * @throws WriterException 编码异常
     * @throws IOException     IO异常
     */
    public static String createQRCode(String barCodeData, String outPath, int height, int width)
            throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(barCodeData, BarcodeFormat.QR_CODE, width, height);
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(matrix);
        ByteArrayOutputStream bof = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", bof);
        String base64 = imageToBase64(bof.toByteArray());
        if (StrUtil.isNotBlank(outPath)) {
            try (FileOutputStream out = new FileOutputStream(outPath)) {
                MatrixToImageWriter.writeToStream(matrix, "png", out);
            }
        }
        return base64;
    }

    /**
     * 图片转base64
     *
     * @param dataBytes 图片字节数组
     * @return base64
     */
    private static String imageToBase64(byte[] dataBytes) {
        // 对字节数组Base64编码
        if (dataBytes != null) {
            return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(dataBytes);// 返回Base64编码过的字节数组字符串
        }
        return null;
    }
}
