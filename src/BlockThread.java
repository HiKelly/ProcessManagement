public class BlockThread implements Runnable{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            try {
                Wait.run();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
