package k1oud.career.wholecareer.concurrency;

/**
 * 测试volatile关键字只能保证并发的可见性&顺序性，并不能保持原子性
 *
 * 启动了10个线程，假设第一个线程已经将num++，num变为1，这个时候还没有经过总线asign，
 * num变化并没有写入主存，资源给了线程2，线程2这个时候对num++，num也变成了1，然后
 * 线程1又抢到了控制权，通过cpu嗅探机制，其他线程里num值均失效，但是此时线程2的一次
 * ++操作已经完成，所以这次操作会无效，因此，输出的num结果是<=10000
 */

public class VolatileTest1 {

    public static volatile int num =0;

    public static void main(String[] args) throws InterruptedException {

       Thread [] threads = new Thread[10];
       for(int i=0;i<threads.length;i++){
           threads[i] = new Thread(new Runnable() {
               @Override
               public void run() {
                   for(int j=0;j<1000;j++){
                       increase();
                   }
               }
           });
           threads[i].start();
       }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(num);

    }

    private static void increase() {
        num++;
    }

}
