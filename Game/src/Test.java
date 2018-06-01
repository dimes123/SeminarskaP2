import javax.swing.*;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Okno okno = new Okno();
        okno.pack();
        okno.setLocationRelativeTo(null);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);
    }
}