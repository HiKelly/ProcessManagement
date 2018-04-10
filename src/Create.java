import java.util.Scanner;
import java.util.TimerTask;

public class Create extends TimerTask {
    @Override
    public void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to input a new process?");  //每次询问是否需要输入新的进程
        System.out.println("Please input 'Y' or 'N':");
        String op = input.next();
        if(op.charAt(0) == 'Y') {   //需要输入新的进程时

            int id = input.nextInt();
            String name = input.next();
            String state = "ready";
            int priority = input.nextInt();
            int totalTime = input.nextInt();
            int finishedTime = 0;

            Process process = new Process(id, name, state, priority, totalTime, finishedTime);  //创建新进程
            Dispatcher.ready.add(process);
            Dispatcher.printReadyProc();
            Dispatcher.printBlockedProc();
            Dispatcher.printFinishedProc();
        }
    }
}