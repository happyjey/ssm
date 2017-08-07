import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/6.
 */
public class Md5 {

    /**
     * 这是HashedCredentialsMatcher加密的方法：
     * 1. 对明文密码做md5加密得到byte[]数组
     * 2. 对byte[]做base64 encode得到字符串
     * ----------------------------------------------------------
     * 之前构造密码失败的原因：
     * 明文密码直接做md5加密得到字段串再进行base64 encode得到字符串，
     * 区别：“字符串”与“字符串的byte[]”做base64的结果是不同的。
     * ----------------------------------------------------------
     */
    @Test
    public void hashedCredentialsMatcher(){
        String pwd = "123123";
        byte[] pwdByte = DigestUtils.md5(pwd);
        String pwdByteEncodeStr = org.apache.commons.codec.binary.Base64.encodeBase64String(pwdByte);
        // 这是HashedCredentialsMatcher加密
        System.out.println(pwdByteEncodeStr);
        System.out.println(new String(pwdByte));
    }

    @Test
    public void test2(){
        String tokenPassword = "123123";
        String tokenCredentials = DigestUtils.md5Hex(tokenPassword);
        System.out.println("加密前"+tokenPassword+" | 加密后"+tokenCredentials);
    }

    @Test
    public void test1(){
        String mima = "4297f44b13955235245b2497399d7a93";
        byte[] mm_md5 = mima.getBytes();
        byte[] md5 = DigestUtils.md5("123123");
        String md5_str = Arrays.toString(md5);
        String mm_md5_str = Arrays.toString(mm_md5);
        System.out.println(md5_str);
        System.out.println(mm_md5_str);
    }
}
