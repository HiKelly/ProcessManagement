import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame{

    private JScrollPane scrollPane;
    private JTextArea textArea;
    public static JTextArea scanfArea;
    public static JButton submit;
    private JButton input;
    private JPanel scanfPane;

    public Main(){
        initComponent();
        System.setOut(new GUIPrintStream(System.out, textArea));
    }

    private void initComponent(){
        scrollPane = new JScrollPane();
        textArea = new JTextArea();
        scanfArea = new JTextArea();
        scanfPane = new JPanel();
        submit = new JButton();
        input = new JButton();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("标准输出重定向到GUI");
        textArea.setColumns(50);
        textArea.setRows(50);
        textArea.setFont(new Font("宋体", 0, 20));
        textArea.setBackground(Color.lightGray);
        scrollPane.setViewportView(textArea);
        scanfArea.setColumns(50);
        scanfArea.setRows(50);
        scanfArea.setFont(new Font("宋体", 0, 20));
        scanfArea.setBackground(Color.pink);
        submit.setText("提交");
        input.setText("输入");
        scanfPane.add(scanfArea);
        scanfPane.add(input);
        scanfPane.add(submit);
        //scanfPane.setViewportView(scanfArea);

        getContentPane().add(scrollPane, BorderLayout.EAST);
        getContentPane().add(scanfPane, BorderLayout.WEST);
        pack(); //调整布局显示
        textArea.setText("");
        scanfArea.setText("Do you want to input a new process?\n");//每次询问是否需要输入新的进程
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == input){
                    scanfArea.setText(null);
                }
            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource() == submit){
                    Admit.go();
                }
            }
        });

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
    }
}
