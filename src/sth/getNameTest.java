package sth;

import java.io.*;
import java.util.*;

import static com.sun.tools.doclint.Entity.cap;
import static com.sun.tools.doclint.Entity.ne;
import static com.sun.tools.doclint.Entity.nu;

/**
 * 获取姓名
 * <p>
 * 从类似如下的文本文件中读取出所有的姓名， 并打印出
 * 重复的姓名和重复的次数， 并按重复次数排序：
 *
 * @Author: milo
 * @Create: 2017-02-15
 */
public class getNameTest {

    public static void main(String[] args) throws IOException {

        String filePath = "person.txt";
        File file = new File(filePath);
        Map map = new HashMap<>();


        if (file.isFile() && file.exists()) {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file));
            BufferedReader bw = new BufferedReader(read);
            String line = null;
            while ((line = bw.readLine()) != null) {
                dealLine(map, line);
            }
            read.close();
            sortResults(map);
        } else {
            System.out.println("找不到文件");
        }
    }

    private static void dealLine(Map map, String line) {

        if (!"".equals(line.trim())) {
            String[] results = line.split(",");
            if (results.length == 3) {
                String name = results[1];
                Integer value = (Integer) map.get(name);
                if (value == null) {
                    value = 0;
                }
                map.put(name, value + 1);
            }
        }
    }

    private static void sortResults(Map results) {
        TreeSet sortedResults = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                User user1 = (User) o1;
                User user2 = (User) o2;
                /**如果compareto返回结果是0,则认为两个对象相等,新的对象不会添加到集合中去
                 * 所以不能直接用下面的代码,否则,那些个数相同的其他姓名就打印不出来
                 * */
                //return user1.getValue() - user2.getValue();
                //return user1.getValue()<user2.getValue()?-1:user1.getValue()==user2.getValue()?0:1;
                if (user1.getValue() < user2.getValue()) {
                    return -1;
                } else if (user1.getValue() > user2.getValue()) {
                    return 1;
                } else {
                    return user1.getName().compareTo(user2.getName());
                }
            }
        });


        Iterator iterator = results.keySet().iterator();
        while (iterator.hasNext()) {
            String name = (String) iterator.next();
            Integer value = (Integer) results.get(name);
            if (value >= 1) {
                sortedResults.add(new User(name, value));

            }
        }
        printResults(sortedResults);
    }

    private static void printResults(TreeSet sortedResults) {
        Iterator iter = (Iterator) sortedResults.iterator();

        while (iter.hasNext()) {
            User user = (User) iter.next();
            System.out.println(user.getName() + ":" + user.getValue());
        }
    }

}

class User {
    private String name;
    private Integer value;

    public User(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return value != null ? value.equals(user.value) : user.value == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}


