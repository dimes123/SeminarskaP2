import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Platno extends JPanel {
    private Okno okno;

    private BufferedImage ozadje;
    private BufferedImage hrbtnaStran;
    private JButton zacetekIgre;
    private JButton novaIgra;

    private Karta S1,S2,S3,S4,S5,S6,S7,S8,
            H1,H2,H3,H4,H5,H6,H7,H8,
            D1,D2,D3,D4,D5,D6,D7,D8,
            C1,C2,C3,C4,C5,C6,C7,C8,
            T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22;

    private ArrayList<Karta> karteIgralec = new ArrayList<>();
    private ArrayList<Karta> karteRacunalnik = new ArrayList<>();

    private JLabel tockeIgr;
    private JLabel tockeRac;

    private Karta kartaIgralec;
    private Karta kartaRacunalnik;
    private int dy = 10;
    private int y = 370;

    private JButton vrziKarto;
    private String sporocilo;

    private int tockeIgralec = 0;
    private int tockeRacunalnik = 0;
    private String kdoJePrvi;
    private int stevec = 0;

    public Platno(Okno okno){
        super();
        this.okno = okno;
        this.zacetekIgre = new JButton("ZAČETEK IGRE");
        this.vrziKarto = new JButton("VRŽI KARTO");
        this.tockeIgr = new JLabel();
        this.tockeRac = new JLabel();
        kdoJePrvi = "igralec";
        definirajKarte();
        zacetekIgre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                pobrisi();
                razdeliKarte(dy, y);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                zacetekIgre.setBorderPainted(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                zacetekIgre.setBorderPainted(false);
            }
        });

        tockeIgr.setText("<html>Točke Igralec<br/><center>"+tockeIgralec+"</center></html>");
        tockeRac.setText("<html>Točke Računalnik<br/><center>"+tockeRacunalnik+"</center></html>");

        zacetekIgre.setBackground(new Color(153,76,0));
        vrziKarto.setBackground(new Color(153,76,0));
        tockeIgr.setBackground(new Color(182, 155, 76));
        tockeRac.setBackground(new Color(182, 155, 76));

        zacetekIgre.setHorizontalAlignment(SwingConstants.CENTER);
        vrziKarto.setHorizontalAlignment(SwingConstants.CENTER);
        tockeIgr.setVerticalAlignment(SwingConstants.CENTER);
        tockeIgr.setHorizontalAlignment(SwingConstants.CENTER);
        tockeRac.setVerticalAlignment(SwingConstants.CENTER);
        tockeRac.setHorizontalAlignment(SwingConstants.CENTER);

        zacetekIgre.setBounds(150,250,400,150);
        vrziKarto.setBounds(250,500,200,100);
        tockeIgr.setBounds(20,0, 120,80);
        tockeRac.setBounds(550,0, 150,80);

        zacetekIgre.setFont(new Font("Impact", Font.PLAIN, 40));
        vrziKarto.setFont(new Font("Impact", Font.PLAIN, 24));
        tockeIgr.setFont(new Font("Impact", Font.PLAIN, 18));
        tockeRac.setFont(new Font("Impact", Font.PLAIN, 18));

        zacetekIgre.setForeground(Color.BLACK);
        vrziKarto.setForeground(Color.BLACK);

        zacetekIgre.setFocusPainted(false);
        vrziKarto.setFocusPainted(false);

        zacetekIgre.setBorderPainted(false);
        vrziKarto.setBorderPainted(false);

        vrziKarto.setVisible(false);
        tockeIgr.setVisible(true);
        tockeRac.setVisible(true);
        zacetekIgre.setVisible(true);



        tockeIgr.setOpaque(true);
        tockeRac.setOpaque(true);

        this.vrziKarto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                igraIgralec();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                vrziKarto.setBorderPainted(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                vrziKarto.setBorderPainted(false);
            }
        });
        try {
            ozadje = ImageIO.read(new File(getClass().getResource("LesenoOzadje.png").getFile()));
            hrbtnaStran = ImageIO.read(new File(getClass().getResource("HrbtnaStran.png").getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.add(vrziKarto);
        this.add(zacetekIgre);
        this.add(tockeIgr);
        this.add(tockeRac);


    }

    public void definirajKarte(){
        //Definiramo karte, p
        T1= new Karta("Karte/T1.png", "tarok", 1, 11);
        T2= new Karta("Karte/T2.png", "tarok", 1, 12);
        T3= new Karta("Karte/T3.png", "tarok", 1, 13);
        T4= new Karta("Karte/T4.png", "tarok", 1, 14);
        T5= new Karta("Karte/T5.png", "tarok", 1, 15);
        T6= new Karta("Karte/T6.png", "tarok", 1, 16);
        T7= new Karta("Karte/T7.png", "tarok", 1, 17);
        T8= new Karta("Karte/T8.png", "tarok", 1, 18);
        T9= new Karta("Karte/T9.png", "tarok", 1, 19);
        T10= new Karta("Karte/T10.png", "tarok", 1, 20);
        T11= new Karta("Karte/T11.png", "tarok", 1, 21);
        T12= new Karta("Karte/T12.png", "tarok", 1, 22);
        T13= new Karta("Karte/T13.png", "tarok", 1, 23);
        T14= new Karta("Karte/T14.png", "tarok", 1, 24);
        T15= new Karta("Karte/T15.png", "tarok", 1, 25);
        T16= new Karta("Karte/T16.png", "tarok", 1, 26);
        T17= new Karta("Karte/T17.png", "tarok", 1, 27);
        T18= new Karta("Karte/T18.png", "tarok", 1, 28);
        T19= new Karta("Karte/T19.png", "tarok", 1, 29);
        T20= new Karta("Karte/T20.png", "tarok", 1, 30);
        T21= new Karta("Karte/T21.png", "tarok", 1, 29);
        T22= new Karta("Karte/T22.png", "tarok", 1, 30);

        S1=new Karta("Karte/S1.png", "pik", 1, 1);
        S2=new Karta("Karte/S2.png", "pik", 1, 2);
        S3=new Karta("Karte/S3.png", "pik", 1, 3);
        S4=new Karta("Karte/S4.png", "pik", 1, 4);
        S5=new Karta("Karte/S5.png", "pik", 2, 5);
        S6=new Karta("Karte/S6.png", "pik", 3, 6);
        S7=new Karta("Karte/S7.png", "pik", 4, 7);
        S8=new Karta("Karte/S8.png", "pik", 5, 8);
        H1=new Karta("Karte/H1.png", "srce", 1, 1);
        H2=new Karta("Karte/H2.png", "srce", 1, 2);
        H3=new Karta("Karte/H3.png", "srce", 1, 3);
        H4=new Karta("Karte/H4.png", "srce", 1, 4);
        H5=new Karta("Karte/H5.png", "srce", 2, 5);
        H6=new Karta("Karte/H6.png", "srce", 3, 6);
        H7=new Karta("Karte/H7.png", "srce", 4, 7);
        H8=new Karta("Karte/H8.png", "srce", 5, 8);
        D1=new Karta("Karte/D1.png", "karo", 1, 1);
        D2=new Karta("Karte/D2.png", "karo", 1, 2);
        D3=new Karta("Karte/D3.png", "karo", 1, 3);
        D4=new Karta("Karte/D4.png", "karo", 1, 4);
        D5=new Karta("Karte/D5.png", "karo", 2, 5);
        D6=new Karta("Karte/D6.png", "karo", 3, 6);
        D7=new Karta("Karte/D7.png", "karo", 4, 7);
        D8=new Karta("Karte/D8.png", "karo", 5, 8);
        C1=new Karta("Karte/C1.png", "križ", 1, 1);
        C2=new Karta("Karte/C2.png", "križ", 1, 2);
        C3=new Karta("Karte/C3.png", "križ", 1, 3);
        C4=new Karta("Karte/C4.png", "križ", 1, 4);
        C5=new Karta("Karte/C5.png", "križ", 2, 5);
        C6=new Karta("Karte/C6.png", "križ", 3, 6);
        C7=new Karta("Karte/C7.png", "križ", 4, 7);
        C8=new Karta("Karte/C8.png", "križ", 5, 8);

        ArrayList<Karta> karte = new ArrayList<>();
        karte.addAll(Arrays.asList(S1,S2,S3,S4,S5,S6,S7,S8,H1,H2,H3,H4,H5,H6,H7,H8,D1,D2,D3,D4,D5,D6,D7,D8,
                C1,C2,C3,C4,C5,C6,C7,C8,T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22));

        Collections.shuffle(karte);

        for(int i=0; i<karte.size(); i++){
            if (i <= (karte.size()/2)-1){
                karteIgralec.add(karte.get(i));
            }
            else {
                karteRacunalnik.add(karte.get(i));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(ozadje, 0,0,this.getWidth(), this.getHeight(), this);
    }

    public void razdeliKarte(int dy, int y){
        ///Nariše hrbtne strani kart
        if (stevec == 0) {
            for (int i = karteIgralec.size() - 1; i >= 0; i--) {
                getGraphics().drawImage(hrbtnaStran, -100, y - dy, this);
                getGraphics().drawImage(hrbtnaStran, 600, y - dy, this);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                y = y - dy;
            }
            stevec++;
        }
        else {
            for (int i = karteIgralec.size() - 1; i >= 0; i--) {
                getGraphics().drawImage(hrbtnaStran, -100, y - dy, this);
                getGraphics().drawImage(hrbtnaStran, 600, y - dy, this);
                y = y - dy;
            }
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (kdoJePrvi.equals("racunalnik")){
                tockeIgr.setBackground(new Color(153,76,0));
                tockeRac.setBackground(new Color(51, 204, 51));
                tockeRac.setText("<html>Točke Računalnik<br/><center>"+tockeRacunalnik+"</center></html>");
            }
            else{
                tockeIgr.setBackground(new Color(51, 204, 51));
                tockeRac.setBackground(new Color(153,76,0));
                tockeIgr.setText("<html>Točke Igralec<br/><center>"+tockeIgralec+"</center></html>");
            }
            this.paintImmediately(200, 210, 100, 180);
            this.paintImmediately(420, 210, 100, 180);

        }





    }

    @Override
    public Dimension getPreferredSize() {
        //Nastavi velikost okna
        return new Dimension(700, 600);
    }

    public void pobrisi(){
        //"Pobriše" gumb Začni Igro in pokaže gumb "Vrži Karto"
        zacetekIgre.setVisible(false);
        vrziKarto.setVisible(true);
    }


    public void igraIgralec() {
        ///Nariše igralčevo karto
        kartaIgralec = karteIgralec.get(0);
        getGraphics().drawImage(kartaIgralec.slika, 200,210, 100,180, this);
        if (kdoJePrvi == "igralec") {
            igraRacunalnik();
        }
        else{
            novaRunda();
        }
    }

    public void igraRacunalnik(){
        //Nariše računalnikovo karto
        kartaRacunalnik = karteRacunalnik.get(0);
        getGraphics().drawImage(kartaRacunalnik.slika, 420,210, 100,180, this);
        if (kdoJePrvi == "igralec"){
            novaRunda();
        }
    }

    public void novaRunda(){
        if (kartaIgralec.barva.equals(kartaRacunalnik.barva)){
            if (kartaIgralec.moc > kartaRacunalnik.moc){
                tockeIgralec = tockeIgralec + kartaIgralec.vrednost+kartaRacunalnik.vrednost;
                kdoJePrvi = "igralec";
            }
            else{
                tockeRacunalnik = tockeRacunalnik + kartaIgralec.vrednost+kartaRacunalnik.vrednost;
                kdoJePrvi = "racunalnik";
            }
        }
        else if(!kartaIgralec.barva.equals(kartaRacunalnik.barva) && (kartaIgralec.barva.equals("tarok") || kartaRacunalnik.barva.equals("tarok"))){
            if (kartaIgralec.barva == "tarok"){
                tockeIgralec = tockeIgralec + kartaIgralec.vrednost+kartaRacunalnik.vrednost;
                kdoJePrvi = "igralec";
            }
            else{
                tockeRacunalnik = tockeRacunalnik + kartaIgralec.vrednost+kartaRacunalnik.vrednost;
                kdoJePrvi = "racunalnik";
            }
            System.out.println("here");
        }

        else{
            if (kdoJePrvi.equals("igralec")){
                tockeIgralec = tockeIgralec + kartaIgralec.vrednost+kartaRacunalnik.vrednost;
                kdoJePrvi = "igralec";
            }
            else{
                tockeRacunalnik = tockeRacunalnik + kartaIgralec.vrednost+kartaRacunalnik.vrednost;
                kdoJePrvi = "racunalnik";
            }
        }
        karteIgralec.remove(kartaIgralec);
        karteRacunalnik.remove(kartaRacunalnik);
        y = y-dy;
        this.paintImmediately(0,40,100,600);
        this.paintImmediately(600,40,100,600);
        razdeliKarte(10,y);
        if (kdoJePrvi.equals("racunalnik")&&karteRacunalnik.size()!=0){
            System.out.println("Sedaj igra računalnik");
            igraRacunalnik();
        }

        if (karteIgralec.size() == 0 && karteRacunalnik.size() == 0){
            y = 370;
            dy = 10;
            if (tockeIgralec>tockeRacunalnik){
                sporocilo = "ZMAGAL JE UPORABNIK!\n Ali bi odigral še eno igro?";
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(this, sporocilo);
                if (dialogResult == 0){
                    okno.novaIgra();
                }
                else{
                    System.exit(0);
                }
            }
            else {
                sporocilo = "ZMAGAL JE RAČUNALNIK\n Ali bi odigral še eno igro?";
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(this, sporocilo);
                if (dialogResult == 0){
                    okno.novaIgra();
                }
                else{
                    System.exit(0);
                }
            }
        }

    }


}
