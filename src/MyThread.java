public class MyThread implements Runnable{
    @Override
    public void run() {
        for(int i = 0;i < 20;i++){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + " running...");
        }

    }
}
