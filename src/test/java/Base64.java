import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * Created by Administrator on 2017/8/6.
 */
public class Base64 {

    @Test
    public void t1(){
        String base64 = org.apache.commons.codec.binary.Base64.encodeBase64String("123123".getBytes());
        System.out.println(base64);
        String en_str = "MTIzMTIz";
        byte[] bytes = org.apache.commons.codec.binary.Base64.decodeBase64(en_str);
        System.out.println(new String(bytes));

        byte[] en_bytes = org.apache.commons.codec.binary.Base64.decodeBase64(en_str.getBytes());
        System.out.println(en_bytes);
        System.out.println(new String(en_bytes));
    }
}
