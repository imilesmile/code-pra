package sword;

/**
 * 替换空格
 * 将一个字符串中的空格替换成“ %20”。例如，当字符串为 We Are Happy.
 则经过替换之后的字符串为 We%20Are%20Happy
 *
 * @Author: milo
 * @Create: 2017-02-09
 */
public class replaceSpace {



    public static String solution1(StringBuffer str) {
        if (str == null) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.toString().length(); i++) {
            if (str.toString().charAt(i)==' '){
                sb.append("%20");
            }else {
                sb.append(str.toString().charAt(i));
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();

        sb.append("hello world");

        String s = replaceSpace.solution1(sb);
        System.out.println("----------------------s值=" + s + "," + "当前类是=replaceSpace.main()");

    }
}
