package sth;

/**
 * 主子线程
 *
 * @Author: milo
 * @Create: 2017-02-14
 */
public class ThreadTest {

    public static void main(String[] args) {
        new ThreadTest().init();

    }

    public void init() {
        final Business business = new Business();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                     business.SubThread(i);

                }
            }
        }) {
        }.start();

        for (int i = 0; i < 50; i++) {
            business.MainThread(i);

        }

    }

    private class Business {
        boolean bShouldSub = true;//定义控制谁该执行的xinhaodeng

        public synchronized void MainThread(int i) {
            if (bShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Thread.currentThread().setName("主线程");

            for (int j = 0; j < 5; j++) {
                System.out.println(Thread.currentThread().getName() + " i=" + i + ",j=" + j);
                bShouldSub = true;
                this.notify();
            }
        }

        public synchronized void SubThread(int i) {
            if (!bShouldSub) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Thread.currentThread().setName("子线程");
            for (int j = 0; j < 10; j++) {
                System.out.println(Thread.currentThread().getName() + " i=" + i + ",j=" + j);
                bShouldSub = false;
                this.notify();
            }
        }
    }
}
