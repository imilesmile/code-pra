package tmp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 截取list
 *
 * @Author: milo
 * @Create: 2017-02-26
 */
public class listSub {



    private static void fenceng(String keyWordsFile) {
        //String ordershowdatafile = "ordershowdata";
        String orderclickdatafile = "orderclickdata";


        List<String> list = new ArrayList<>();
        int numcount = 0;

        try {
            //System.out.println("ordershowdata");
            InputStreamReader read = new InputStreamReader(new FileInputStream(orderclickdatafile), "utf8");
            BufferedReader reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {

                list.add(line);

                numcount++;
            }
            read.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        //for (String s : list) {
        //    System.out.println(s);
        //}


        Map<Integer, Integer> map = new HashMap<>();

        Set<Integer> sourceset = new HashSet<>();

        try {
            //System.out.println("java");
            InputStreamReader read = new InputStreamReader(new FileInputStream(keyWordsFile), "utf8");
            BufferedReader reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitarr = line.split("\t");

                for (String s : splitarr) {
                    String[] split = s.split(",");
                    int pid = Integer.parseInt(split[0]);

                    map.put(pid, 0);
                    sourceset.add(pid);
                }


            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //    System.out.println(entry);
        //}

        //for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
        //    list.add((Map<String, String>) stringStringEntry);
        //}

        //取交集
        List<String> keywordlist = new ArrayList<>();
        //System.out.println("取交集");


        //for (String s : list) {
        //    String[] sp = s.split("\t");
        //    int kpid = Integer.parseInt(sp[0]);
        //    String kpname = sp[1];
        //    int ktotal = Integer.parseInt(sp[2]);
        //
        //
        //    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //        Integer key = entry.getKey();
        //        Integer value = entry.getValue();
        //
        //        if (key == kpid) {
        //
        //            //keywordlist.add(key + "\t" + ktotal);
        //            merge.writetofile("crossjava", kpid + "\t" + ktotal + "\r\n");
        //
        //        } else {
        //            merge.writetofile("crossjava", key + "\t" + value + "\r\n");
        //        }
        //    }
        //
        //
        //}

        Set<Integer> set = new HashSet<>();


        for (String s : list) {
            String[] sp = s.split("\t");
            int kpid = Integer.parseInt(sp[0]);
            String kpname = sp[1];
            int ktotal = Integer.parseInt(sp[2]);

            if (map.containsKey(kpid)) {

                //keywordlist.add(key + "\t" + ktotal);
                //merge.writetofile("cross/crossjava", kpid + "\t" + ktotal+ "\r\n");
                keywordlist.add(kpid + "\t" + ktotal);

                set.add(kpid);


            }
        }


        sourceset.removeAll(set);


        for (Integer integer : sourceset) {


            //merge.writetofile("cross/crossjava",integer + "\t" + 0 + "\r\n");
            keywordlist.add(integer + "\t" + 0);


        }
        //for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //
        //    for (Integer integer : sourceset) {
        //        int pid = integer;
        //
        //        if (pid ==kpid){
        //            merge.writetofile("cross/crossjava",integer + "\t" + kpname+ "\t" + 0 + "\r\n");
        //        }
        //
        //
        //    }
        //
        //}


        //System.out.println("取交集完毕");

        //System.out.println(numcount);
        //System.out.println(map.size());

        System.out.println("list的size是:" + list.size());

        int sum = 0;

        for (int i = 1; i < 51; i++) {

            int count = 0;

            int page = i;


            //List clist=adminbiz.queryNotFullCourse();//将查询结果存放在List集合里
            PageBean pagebean = new PageBean(list.size());//初始化PageBean对象
            //设置当前页
            pagebean.setCurPage(page); //这里page是从页面上获取的一个参数，代表页数
            //获得分页大小
            int pagesize = pagebean.getPageSize();
            //获得分页数据在list集合中的索引
            int firstIndex = (page - 1) * pagesize;
            int toIndex = page * pagesize;
            if (toIndex > list.size()) {
                toIndex = list.size();
            }
            if (firstIndex > toIndex) {
                firstIndex = 0;
                pagebean.setCurPage(1);
            }
            //截取数据集合，获得分页数据
            List<String> courseList = list.subList(firstIndex, toIndex);
            for (String s : courseList) {
                String[] split = s.split("\t");
                String pid = split[0];
                //String pname = split[1];
                String total = split[1];

                System.out.println(s);
                count++;
                sum++;


                //if (pname.contains("大数据")) {
                //
                //    System.out.println(s);
                //    count++;
                //    sum++;
                //}
                //count++;

                //写入文件
                merge.writetofile("clickpids", s + "\r\n");
                if (count == 10) {break;}}System.out.println(sum);}}

    public static void main(String[] args) {
        String keyWordsFile = "source/yunying";

        fenceng(keyWordsFile);


    }
}
