package tmp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: milo
 * @Create: 2017-02-27
 */
public class filemerge {

    public static void main(String[] args) {
        String mergeFile = "showfenceng/yunying";

        String positionDetailfile = "positionDetail";

        HashMap<Integer, String> positionDetailmap = new HashMap<>();



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


        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(mergeFile), "gbk");
            BufferedReader reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("\t");
                int pid = Integer.parseInt(split[0]);
                String total = split[1];

                merge.writetofile("showpids", pid + "\t" + positionDetailmap.get(pid) + "\t" + total +"\r\n" );


            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
