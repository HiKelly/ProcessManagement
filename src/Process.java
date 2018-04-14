public class Process implements Comparable<Process>{

    private int id;  //进程内部标识符
    private String name;    //进程外部标识符
    private String state;   //进程状态
    private int priority;   //进程优先级
    private long totalTime;  //进程所需总时间
    private long finishedTime;   //进程已用时间
    private boolean isBlocked;  //进程是否需要I/O
    private long inRunningTime; //进程进入running队列的时间
    private long inBlockedTime; //进程进入blocked等待I/O的时间
    private long blockedTime;  //进程需要I/O多久

    public Process(int id, String name, String state, int priority, long totalTime, long finishedTime, boolean isBlocked, long inRunningTime, long inBlockedTime, long blockedTime){
        this.id = id;
        this.name = name;
        this.state = state;
        this.priority = priority;
        this.totalTime = totalTime;
        this.finishedTime = finishedTime;
        this.isBlocked = isBlocked;
        this.inRunningTime = inRunningTime;
        this.inBlockedTime = inBlockedTime;
        this.blockedTime = blockedTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public long getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(long finishedTime) {
        this.finishedTime = finishedTime;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public boolean getIsBlocked() { return isBlocked; }

    public void setIsBlocked(boolean blocked) { isBlocked = blocked; }

    public long getBlockedTime() { return blockedTime; }

    public void setBlockedTime(long blockedTime) { this.blockedTime = blockedTime; }

    public long getInRunningTime() { return inRunningTime; }

    public void setInRunningTime(long inRunningTime) { this.inRunningTime = inRunningTime; }

    public long getInBlockedTime() { return inBlockedTime; }

    public void setInBlockedTime(long inBlockedTime) { this.inBlockedTime = inBlockedTime; }

    @Override
    public int compareTo(Process o) {
        if(this.getPriority() != o.getPriority())
            return (this.getPriority() - o.getPriority());
        return (this.getId() - o.getId());
    }

    public void printStatus(){
        System.out.print("id = " + id + ", name = " + name + ", priority = "
                + priority + ", total = " + totalTime + ", finished = " + finishedTime + ", isBlocked = ");
        if(isBlocked == true){
            System.out.println("Y, blockedTime = " + blockedTime);
        }
        else
            System.out.println("N");
    }

}