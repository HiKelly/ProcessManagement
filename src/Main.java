import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main extends JFrame{

    private JScrollPane scrollPane;
    private JTextArea textArea;

    public Main(){
        initComponent();
        System.setOut(new GUIPrintStream(System.out, textArea));
    }

    private void initComponent(){
        scrollPane = new JScrollPane();
        textArea = new JTextArea();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("标准输出重定向到GUI");
        textArea.setColumns(100);
        textArea.setRows(50);
        textArea.setFont(new Font("宋体", 0, 18));
        scrollPane.setViewportView(textArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        pack();
    }

    public static void main(String args[]) throws IOException, InterruptedException{
        Admit.startCreate();    //将文件里的进程加入到ready队列
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run(){
                new Main().setVisible(true);
                Thread th = new Thread(new MyThread()); //整个ProcessManagement开始运作
                th.start();
            }
        });
        Timer t = new Timer();
        t.schedule(new Admit(), 10000, 5000);

        while(true){
            Thread.sleep(1000);
        }
    }
}
