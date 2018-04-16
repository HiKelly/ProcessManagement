public class Wait {

    public static void add(Process proc){
        proc.setFinishedTime(proc.getInBlockedTime());
        MyThread.running.poll();
        MyThread.blocked.add(proc);
        MyThread.print();
        Process readyProc = MyThread.ready.peek();
        if(readyProc != null) {
            MyThread.ready.poll();
            MyThread.running.add(readyProc);
            readyProc.setInRunningTime(System.currentTimeMillis());    //标记进程进入running队列时间
            MyThread.print();
        }
        else    //若ready队列也为空，则当前无可运行进程
            System.out.println("No Process will be running...");
    }

    public static void run(){
        Process proc = MyThread.blocked.peek();
        long time = System.currentTimeMillis();
        if(proc == null){
            return;
        }
        else {
            MyThread.print();
            MyThread.blocked.poll();
            long now = System.currentTimeMillis() - time;
            while (now + proc.getFinishedTime() < proc.getBlockedTime() && now < MyThread.cycleTime){
                now = System.currentTimeMillis() - time;
                //仍在I/O，不进入ready队列
            }
            if(now >= MyThread.cycleTime){
                proc.setFinishedTime(proc.getFinishedTime() + now);
                Dispatch.run();
            }
            else{
                proc.setIsBlocked(false);
                proc.setFinishedTime(proc.getInBlockedTime() + proc.getBlockedTime());
                MyThread.ready.add(proc);
                MyThread.print();
            }
        }
    }

}
