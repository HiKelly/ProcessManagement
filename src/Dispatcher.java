import java.io.IOException;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class Dispatcher {

    private int sysTime;    //系统时间
    public static PriorityBlockingQueue<Process> ready = new PriorityBlockingQueue();   //就绪队列
    public static PriorityBlockingQueue<Process> blocked = new PriorityBlockingQueue(); //阻塞队列
    public static PriorityBlockingQueue<Process> finished = new PriorityBlockingQueue();    //完成队列
    private Process running;    //正在进行的队列

    public Dispatcher(){

    }

    //遍历ready队列
    public static void printReadyProc(){
        Arrays.sort(ready.toArray());
        for(Process x: ready){
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
    
    //进程取出
    public Process delReadyProc(){
        if(ready.size() <= 0){
            return null;
        }
        return this.ready.remove();    //返回最小的一个
    }

    //优先级抢占算法的调度
    public void run(int time){
        int proctimeslice = 1;  //假设处理器时钟周期
        while(time > 0){    //处理机运行时间
            if(this.running == null){
                this.running = this.delReadyProc();
            }
            else{
                Process proc = this.running;
            }
        }
    }

}
