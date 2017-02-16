package hwdt;

/**
 * 计算
 * <p>
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * <p>
 * 输入描述:
 * <p>
 * 一行字符串，非空，长度小于5000。
 * <p>
 * 输出描述:
 * <p>
 * 整数N，最后一个单词的长度。
 * <p>
 * 输入例子:
 * <p>
 * hello world
 * <p>
 * 输出例子:
 * <p>
 * 5
 *
 * @Author: milo
 * @Create: 2017-02-16
 */
public class lastWordSum {

    public static void solution(String str) {
        if (str != null) {
            String[] split = str.split(" ");

            String word = split[split.length - 1];

            System.out.println(word.length());
        }
    }

    public static void main(String[] args) {

        String string = "hello world";
        solution(string);
    }
}
