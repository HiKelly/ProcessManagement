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
        String str;
        for(int i = 0; i < 7; i++)
            str = tokens.nextToken();
        int id = Integer.valueOf(tokens.nextToken()).intValue();
        String name = tokens.nextToken();
        String state = "ready";
        int priority = Integer.valueOf(tokens.nextToken()).intValue();
        int totalTime = Integer.valueOf(tokens.nextToken()).intValue();
        int finishedTime = 0;
        String is = tokens.nextToken();
        boolean isBlocked;
        if(is.charAt(0) == 'Y')
            isBlocked = true;
        else isBlocked = false;
        long inRunningTime = 0;
        long inBlockedTime = Long.valueOf(tokens.nextToken()).longValue();
        long blockedTime = Long.valueOf(tokens.nextToken()).longValue();

        Process process = new Process(id, name, state, priority, totalTime, finishedTime, isBlocked, inRunningTime, inBlockedTime, blockedTime);  //创建新进程
        MyThread.ready.add(process);
        MyThread.printReadyProc();
        MyThread.printBlockedProc();
        MyThread.printFinishedProc();
        Main.scanfArea.setText("Do you want to input a new process?\n");//每次询问是否需要输入新的进程
    }
}