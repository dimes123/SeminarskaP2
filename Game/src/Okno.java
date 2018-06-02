import javax.swing.*;
import java.awt.*;

public class Okno extends JFrame{
    Platno platno;

    public Okno(){
        super();
        platno = new Platno();
        platno.setLayout(null);
        add(platno);
    }


}
