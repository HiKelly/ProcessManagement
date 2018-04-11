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

        Thread th = new Thread(new MyThread()); //整个ProcessManagement开始运作
        th.start();
        /*Timer t = new Timer();
        t.schedule(new Admit(), 10000, 5000);

        while(true){
            Thread.sleep(1000);
        }*/


    }
}

