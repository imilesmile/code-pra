package tmp;

import java.io.*;
import java.util.*;

/**
 * @Author: milo
 * @Create: 2017-02-26
 */
public class merge {


    public static void main(String[] args) {

        //String clickdatafile = "clickdata";
        String showdatafile = "showdata";
        String positionDetailfile = "positionDetail";



        HashMap<Integer, Integer> showdatamap = new HashMap<>();
        HashMap<Integer, String> positionDetailmap = new HashMap<>();

        Map<String, Integer> map = new HashMap<String, Integer>();


        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(showdatafile),"utf-8");
            BufferedReader reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\t");

                int pid = Integer.parseInt(split[0]);
                int count = Integer.parseInt(split[1]);

                showdatamap.put(pid, count);

                //System.out.println(pid + "-" + count);


            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(positionDetailfile), "gbk");
            BufferedReader reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\t");

                int pid = Integer.parseInt(split[0]);
                String pname = split[1];

                positionDetailmap.put(pid, pname);

                //System.out.println(pid + "-" + count);


            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> showdataentry : showdatamap.entrySet()) {
            //for (Map.Entry<Integer, String> positionDetailentry : positionDetailmap.get) {
            if (positionDetailmap.get(showdataentry.getKey()) != null) {
                //System.out.println(showdataentry.getKey() + " " + positionDetailmap.get(showdataentry.getKey()) + " " + showdataentry.getValue());
                //count++;
                map.put(showdataentry.getKey() + "\t" + positionDetailmap.get(showdataentry.getKey()), showdataentry.getValue());
            }


            //System.out.println(showdataentry.getKey() + " " + showdataentry.getValue());

            //}

        }

        System.out.println(count);

        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        //默认从小到大排序,若要倒序可以交换相减的顺序
        //若是字符串或其他自定义类之间的比较,可以使用compareTo
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {

            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //return (o1.getKey() - o2.getKey());//根据key排序
                return (o2.getValue() - o1.getValue());//根据value排序
                //return (o1.getKey()).toString().compareTo(o2.getKey());
            }
        });

        //for (Map.Entry<String, Integer> entry : entryList) {
        //    System.out.println(entry.getKey() + "\t" + entry.getValue());
        //
        //    writetofile("orderclickdata", entry.getKey() + "\t" + entry.getValue() + "\r\n");
        //
        //
        //}

        System.out.println(entryList.size());


    }

    /**
     * 追加文件：使用FileOutputStream，在构造FileOutputStream时，把第二个参数设为true
     *
     * @param file
     * @param content
     */
    public static void writetofile(String file, String content) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            out.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
