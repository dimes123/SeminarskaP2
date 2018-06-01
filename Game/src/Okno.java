import javax.swing.*;

public class Okno extends JFrame{
    Platno platno;

    public Okno(){
        super();
        platno = new Platno();
        add(platno);
    }


}
