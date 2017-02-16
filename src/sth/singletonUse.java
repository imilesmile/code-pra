package sth;

import java.util.HashMap;

/**
 * 单例模式应用
 *
 * @Author: milo
 * @Create: 2017-02-15
 */
class SequenceGenerator {
    //下面是该类的自身的业务功能代码
    /*private int count = 0;

    public synchronized int getSequence() {
        ++count;
    }*/

    //下面是把该类变成单例的代码

    private SequenceGenerator() {
    }

    private static SequenceGenerator sequenceGenerator = new SequenceGenerator();

    public static SequenceGenerator getSequenceGenerator() {
        return sequenceGenerator;
    }
}


class MemoryDao{
    private HashMap map = new HashMap();

    public void add(String s){
        //map.put(SequenceGenerator.getSequenceGenerator().ge)
    }
}
