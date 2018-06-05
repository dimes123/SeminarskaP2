import javax.swing.*;
import java.awt.*;

public class Okno extends JFrame{
    Platno platno;

    public Okno(){
        super();
        platno = new Platno(this);
        platno.setLayout(null);
        add(platno);
    }

    public void novaIgra(){
        remove(platno);
        platno = new Platno(this);
        platno.setLayout(null);
        add(platno);
    }


}
