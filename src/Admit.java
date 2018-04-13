import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Admit {

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

    public static void go(){

        String s = Main.scanfArea.getText();
        StringTokenizer tokens = new StringTokenizer(s);
        int id = Integer.valueOf(tokens.nextToken()).intValue();
        String name = tokens.nextToken();
        String state = "ready";
        int priority = Integer.valueOf(tokens.nextToken()).intValue();
        int totalTime = Integer.valueOf(tokens.nextToken()).intValue();
        int finishedTime = 0;
        boolean isBlocked = Boolean.valueOf(tokens.nextToken()).booleanValue();
        long inRunningTime = 0;
        long inBlockedTime = 0;
        long blockedTime = Long.valueOf(tokens.nextToken()).longValue();

        Process process = new Process(id, name, state, priority, totalTime, finishedTime, isBlocked, inRunningTime, inBlockedTime, blockedTime);  //创建新进程
        MyThread.ready.add(process);
        MyThread.printReadyProc();
        MyThread.printBlockedProc();
        MyThread.printFinishedProc();
        Main.scanfArea.setText("Do you want to input a new process?\n");//每次询问是否需要输入新的进程
    }
}