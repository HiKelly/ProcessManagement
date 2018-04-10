public class Device {

    private int dcTime; //该设备一次I/O服务需要的时间
    private int dcPid;  //使用该设备的进程
    private int deLeftTime; //设备剩余服务时间

    public Device(int dcTime, int dcPid, int deLeftTime){
        this.dcTime = dcTime;
        this.dcPid = dcPid;
        this.deLeftTime = deLeftTime;
    }

    public void setDcTime(int dcTime) {
        this.dcTime = dcTime;
    }

    public int getDcTime() {
        return dcTime;
    }

    public void setDcPid(int dcPid) {
        this.dcPid = dcPid;
    }

    public int getDcPid() {
        return dcPid;
    }

    public void setDeLeftTime(int deLeftTime) {
        this.deLeftTime = deLeftTime;
    }

    public int getDeLeftTime() {
        return deLeftTime;
    }
}
