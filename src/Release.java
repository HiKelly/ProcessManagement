public class Release {
    public static void run(Process proc){
        MyThread.running.poll();
        proc.setFinishedTime(proc.getTotalTime());
        MyThread.finished.add(proc);
        MyThread.print();
    }
}
