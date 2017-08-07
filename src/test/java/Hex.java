import org.junit.Test;

/**
 * Created by Administrator on 2017/8/7.
 */
public class Hex {

    @Test
    public void test1(){
        String str = "297f44b13955235245b2497399d7a93";
        byte[] bytes = str.getBytes();
//        byte[] bytesHex = org.apache.shiro.codec.Hex.decode(bytes);
        System.out.println(new String(bytes));
//        System.out.println(bytesHex);
    }
}
