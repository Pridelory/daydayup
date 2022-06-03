package encoding;

import java.util.Base64;

/**
 * @ClassName Base64Util
 * @Description Base64 Demo
 * @Author wangmeng
 * @Date 2021/12/26
 */
public class Base64Util {

    public static String encode(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    public static String decode(String base64Data) {
        return new String(Base64.getDecoder().decode(base64Data));
    }

    public static void main(String[] args) {
        String encodedString = Base64Util.encode("abcdefg");    // YWJjZGVmZw==
        System.out.println(encodedString);
        String decodedString = Base64Util.decode(encodedString);
        System.out.println(decodedString);
    }
}
