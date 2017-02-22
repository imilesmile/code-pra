package sth;

/**
 * 单例模式
 *
 * @Author: milo
 * @Create: 2017-02-15
 */
class singleTon {

    private singleTon() {
    }

    private static singleTon singleTon = new singleTon();

    public static singleTon getInstance() {
        return singleTon;
    }
}

class lazySingleTon {
    private lazySingleTon() {
    }

    private static lazySingleTon lst = null;

    public static synchronized lazySingleTon getInstance() {
        if (lst == null) {
            lst = new lazySingleTon();
        }
        return lst;
    }
}