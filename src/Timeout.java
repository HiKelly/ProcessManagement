public class Timeout {
    public static void add(Process proc){
        proc.setFinishedTime(proc.getFinishedTime() + MyThread.cycleTime);
        MyThread.running.add(proc);
        MyThread.print();
    }
}
