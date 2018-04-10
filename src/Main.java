import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception{

        //输入起始进程
        FileInputStream file = new FileInputStream("in.txt");
        System.setIn(file);
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int id = in.nextInt();
            String name = in.next();
            String state = "ready";
            int priority = in.nextInt();
            int totalTime = in.nextInt();
            int finishedTime = 0;

            Process process = new Process(id, name, state, priority, totalTime, finishedTime);  //创建新进程
            Dispatcher.ready.add(process);
        }

        Thread th = new Thread(new MyThread());
        th.start();
        Timer t = new Timer();
        t.schedule(new Create(), 10000, 5000);

        while(true){
            Thread.sleep(1000);
        }


    }
}

