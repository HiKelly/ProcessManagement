import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.io.OutputStream;
import java.io.PrintStream;

public class GUIPrintStream extends PrintStream{

    private JTextComponent component;
    private StringBuffer sb = new StringBuffer();

    public GUIPrintStream(OutputStream out, JTextComponent component){
        super(out);
        this.component = component;
    }

    public void write(byte[] buf, int off, int len){
        final String message = new String(buf, off, len);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                sb.append(message);
                component.setText(sb.toString());
            }
        });
    }
}
