import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.TimerTask;

public class Admit extends TimerTask {

    public static void startCreate() throws IOException{
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
            boolean isBlocked = in.nextBoolean();
            long inRunningTime = 0;
            long inBlockedTime = in.nextLong();
            long blockedTime = in.nextLong();

            Process process = new Process(id, name, state, priority, totalTime, finishedTime, isBlocked, inRunningTime, inBlockedTime, blockedTime);  //创建新进程
            MyThread.ready.add(process);
        }
    }

    @Override
    public void run(){
        Scanner input = new Scanner(System.in);
        //System.out.println("Do you want to input a new process?");  //每次询问是否需要输入新的进程
        //System.out.println("Please input 'Y' or 'N':");
        String op = input.next();
        if(op.charAt(0) == 'Y') {   //需要输入新的进程时

            int id = input.nextInt();
            String name = input.next();
            String state = "ready";
            int priority = input.nextInt();
            int totalTime = input.nextInt();
            int finishedTime = 0;
            boolean isBlocked = input.nextBoolean();
            long inRunningTime = 0;
            long inBlockedTime = 0;
            long blockedTime = input.nextLong();

            Process process = new Process(id, name, state, priority, totalTime, finishedTime, isBlocked, inRunningTime, inBlockedTime, blockedTime);  //创建新进程
            MyThread.ready.add(process);
            MyThread.printReadyProc();
            MyThread.printBlockedProc();
            MyThread.printFinishedProc();
        }
    }
}