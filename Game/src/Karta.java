import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Karta {
    //Ustvarimo karte
    public int moc;
    public String barva;
    public int vrednost;
    public BufferedImage slika;

    public Karta(String pot, String barva, int vrednost, int moc){
        //Konstruktor, nastavi vrednosti atributov
        this.moc = moc;
        this.barva = barva;
        this.vrednost = vrednost;
        try {
            this.slika = ImageIO.read(new File(getClass().getResource(pot).getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
