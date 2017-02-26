package tmp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 截取list
 *
 * @Author: milo
 * @Create: 2017-02-26
 */
public class listSub {

    public static void main(String[] args) {

        String ordershowdatafile = "ordershowdata";

        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int numcount = 0;

        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(ordershowdatafile), "utf8");
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

        //for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
        //    list.add((Map<String, String>) stringStringEntry);
        //}

        System.out.println(numcount);
        //System.out.println(map.size());

        System.out.println(list.size());

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
                String pname = split[1];
                String total = split[2];



                if (pname.contains("大数据")) {

                    System.out.println(s);
                    count++;
                    sum++;
                }
                //count++;


                if (count == 10) {
                    break;
                }


            }


            System.out.println(sum);
        }



    }
}
