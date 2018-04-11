public class Release {
    public static void run(Process proc){
        proc.setFinishedTime(proc.getTotalTime());
        MyThread.finished.add(proc);
        MyThread.print();
    }
}
