package sth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 文件交替拷贝
 * <p>
 * 将 a.txt 文件中的单词与 b.txt 文件中的
 * 单词交替合并到 c.txt 文件中， a.txt 文件中的单词用回车符
 * 分隔， b.txt 文件中用回车或空格进行分隔
 *
 * @Author: milo
 * @Create: 2017-02-14
 */
public class TwoFileAlterCopy {
    public static void main(String[] args) throws Exception {
        FileManager a = new FileManager("", new char[]{'\n'});
        FileManager b = new FileManager("", new char[]{'\n', ' '});
        FileWriter c = new FileWriter("c.txt");
        String aWord = null;
        String bWord = null;


    }
}

class FileManager {

    String[] words = null;
    int pos = 0;

    public FileManager(String filename, char[] seperators) throws Exception {
        File f = new File(filename);
        FileReader reader = new FileReader(f);
        char[] buf = new char[(int) f.length()];
        int len = reader.read(buf);
        String results = new String(buf, 0, len);
        String regex = null;
        if (seperators.length > 1) {
            regex = "" + seperators[0] + "|" + seperators[1];
        } else {
            regex = "" + seperators[0];
        }
        words = results.split(regex);
    }

    public String nextWords() {
        if (pos == words.length)
            return null;
        return words[pos++];
    }
}
