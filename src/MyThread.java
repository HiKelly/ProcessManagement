import com.sun.xml.internal.ws.encoding.MtomCodec;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.PriorityBlockingQueue;

public class MyThread implements Runnable{

    public static long cycleTime = 3000;
    public static PriorityBlockingQueue<Process> ready = new PriorityBlockingQueue();   //就绪队列
    public static PriorityBlockingQueue<Process> running = new PriorityBlockingQueue(); //运行队列
    public static PriorityBlockingQueue<Process> blocked = new PriorityBlockingQueue(); //阻塞队列
    public static PriorityBlockingQueue<Process> finished = new PriorityBlockingQueue();    //完成队列

    //遍历ready队列
    public static void printReadyProc(){
        Arrays.sort(ready.toArray());
        for(Process x: ready){
            x.printStatus();
        }
    }

    //遍历running队列
    public static void printRunningProc(){
        Arrays.sort(running.toArray());
        for(Process x: running){
            x.printStatus();
        }
    }

    //遍历blocked队列
    public static void printBlockedProc(){
        Arrays.sort(blocked.toArray());
        for(Process x: blocked){
            x.printStatus();
        }
    }

    //遍历finished队列
    public static void printFinishedProc(){
        Arrays.sort(finished.toArray());
        for(Process x: finished){
            x.printStatus();
        }
    }

    public static void print(){
        System.out.println("以下为ready队列...");
        MyThread.printReadyProc();
        System.out.println("以下为running队列...");
        MyThread.printRunningProc();
        System.out.println("以下为blocked队列...");
        MyThread.printBlockedProc();
        System.out.println("以下为finished队列...");
        MyThread.printFinishedProc();
        System.out.println();
    }

    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Dispatch.run(); //从ready中取出优先级最高的放到running中
            } catch (Exception e){
                e.printStackTrace();
            }
            Wait.run();
        }

    }
}
