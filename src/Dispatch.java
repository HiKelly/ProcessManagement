public class Dispatch {

    //优先级抢占算法的调度
    public static void run(){
        Process proc = MyThread.running.peek();
        if(proc == null){   //running队列为空可直接加入到running队列
            Process readyProc = MyThread.ready.peek();
            if(readyProc != null) {
                MyThread.ready.poll();
                MyThread.running.add(readyProc);
                readyProc.setInRunningTime(System.currentTimeMillis());    //标记进程进入running队列时间
                MyThread.print();
            }
            else    //若ready队列也为空，则当前无可运行进程
                System.out.println("No Process will be running...\n");
        }
        else {
            long now = System.currentTimeMillis() - proc.getInRunningTime();
            while (((proc.getIsBlocked() == false && now < proc.getTotalTime())
                    || (proc.getIsBlocked() == true && now < proc.getInBlockedTime())
                    && now < MyThread.cycleTime)){
                now = System.currentTimeMillis() - proc.getInRunningTime();
                //不需要被中断且为超过运行时间，或需要被打断但未到中断时间，并且时间片都继续循环
            }
            if(proc.getIsBlocked() == false && now >= proc.getTotalTime()){ //进程运行结束，加入finished队列
                Release.run(proc);
            }
            else if(proc.getIsBlocked() == true && now >= proc.getInBlockedTime()){   //进程被中断，加入blocked队列
                Wait.add(proc);
            }
            else{   //进程运行被终止，重新放到ready队列等待
                Timeout.add(proc);
                Wait.run();
            }
        }
    }

}
