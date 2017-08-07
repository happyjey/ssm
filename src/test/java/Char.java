import org.junit.Test;

/**
 * Created by Administrator on 2017/8/7.
 */
public class Char {

    /**
     * char为单引号
     * 字符串为双引号
     */
    @Test
    public void test1(){
        char[] chars = new char[3];
        chars[0] = '1';
        chars[1] = '2';
        chars[2] = 'a';
        System.out.println(chars);

        String str = "123123";
        Object chars2 = str.toCharArray();
        char[] str2 = (char[]) chars2;
        System.out.println(str2);
        System.out.println(String.valueOf(str2));
    }
}
