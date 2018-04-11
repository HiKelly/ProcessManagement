public class Wait {

    public static void add(Process proc){
        proc.setInRunningTime(System.currentTimeMillis());
        MyThread.blocked.add(proc);
        MyThread.print();
    }

    public static void run(){
        Process proc = MyThread.blocked.peek();
        if(proc == null){
            return;
        }
        else {
            MyThread.blocked.poll();
            long now = System.currentTimeMillis() - proc.getInBlockedTime();
            while (now < proc.getBlockedTime()){
                //仍在I/O，不进入ready队列
            }
            proc.setIsBlocked(false);
            MyThread.ready.add(proc);
        }
    }

}
