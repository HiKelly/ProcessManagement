import java.io.FileWriter;
import java.io.IOException;

public class Process implements Comparable<Process>{

    private int id;  //进程内部标识符
    private String name;    //进程外部标识符
    private String state;   //进程状态
    private int priority;   //进程优先级
    private int totalTime;  //进程所需总时间
    private int finishedTime;   //进程已用时间

    public Process(int id, String name, String state, int priority, int totalTime, int finishedTime){
        this.id = id;
        this.name = name;
        this.state = state;
        this.priority = priority;
        this.totalTime = totalTime;
        this.finishedTime = finishedTime;
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

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(int finishedTime) {
        this.finishedTime = finishedTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    @Override
    public int compareTo(Process o) {
        return (this.getPriority() - o.getPriority());
    }

    public void printStatus(){
        System.out.println("PCB id = " + id + ", name = " + name + ", priority = "
                + priority + ", totalTime = " + totalTime + ", finishedTime = " + finishedTime);
    }

}