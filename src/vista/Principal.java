package vista;
//Letra 24,118,3

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import modelo.Jugador;

public class Principal extends JFrame implements ActionListener {

    private JTextField caja,caja2;
    private JLabel numero,monto;
    private JLabel texto, texto1, autor, pal,pal2, nopal, contarL,contarP, eliminar;
    private JButton cerrar, operar,jugar;
    private JComboBox combo;
    private JPanel panelIzquierdo, panelDerecho;
    private Font fuente, fuente1, fuente2;
    private Cursor mano;
    private Border bordesitosxd, bordes, bordes1, bordes2;
    private StringTokenizer st;
    //-----------------
    private int contador=0;
    private String valor;
    private String valor1 = "";
    private char[] arrayChar;

    public Principal() {   // Creacion de la ventana 
        setSize(1100, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setVisible(true);
        // Se instancian los metodos de los Paneles xd
        Panel1();
        Panel2();
        Componentes();
        //---------------------
        combo = new JComboBox();
        combo.addItem("✔ Guayabita");
        combo.addItem("✔ Ruleta");
        combo.addItem("✔ Adivina el numero");


       
        combo.setBounds(getWidth() / 2 + 100, 160, 170, 22);
        combo.setLayout(null);
        combo.setSelectedIndex(-1);
        combo.setBackground(new Color(24,118,3));
        combo.setForeground(new Color(235, 196, 56));
        combo.addActionListener(this);
        panelDerecho.add(combo);
        combo.updateUI();

///Musica-------
           try {
            AudioClip clip;
            File Url = new File("src/sonidos/casino.wav");

            clip = Applet.newAudioClip(Url.toURI().toURL());
           // clip.loop();
            //clip.play();

        } catch (Exception ex) {

            System.err.println(ex + " error");

        }
        

    }

    public void Panel1() {
        // Creacion del JPanel Izquierda
        panelIzquierdo = new JPanel();
        panelIzquierdo.setBounds(0, 0, getWidth() / 2, getHeight());
        panelIzquierdo.setBackground(new Color(124,6,0));
        panelIzquierdo.setLayout(null);
        this.add(panelIzquierdo);
        panelIzquierdo.updateUI();
    }

    public void Panel2() {
        // Creacion del JPanel Derecho
        panelDerecho = new JPanel();
        panelDerecho.setBounds(getWidth() / 2, 0, getWidth(), getHeight());
        panelDerecho.setBackground(new Color(165,209,133));
        panelDerecho.setLayout(null);
        this.add(panelDerecho);
        panelDerecho.updateUI();
    }

    public void Componentes() {
        fuente = new Font("Berlin Sans FB", Font.BOLD, 35);
        fuente2 = new Font("Berlin Sans FB", Font.BOLD, 16);
        fuente1 = new Font("Comic Sans MS", Font.BOLD, 11);
        mano = new Cursor(HAND_CURSOR);
        //----------------------- 
        texto = new JLabel("$$$ LUXURY DICE $$$");
        texto.setFont(fuente);
        texto.setBounds(getWidth() / 2 -500, getHeight() / 2 - 150, 450, 30);
        texto.setForeground(new Color(234, 190, 63));
        panelIzquierdo.add(texto);
        //------------------------
        texto1 = new JLabel("*Seleccione un juego: ");
        texto1.setFont(fuente2);
        texto1.setForeground(new Color(24,118,3));
        texto1.setBounds(getWidth() / 2 + 120, 120, 390, 20);
        panelDerecho.add(texto1);
        texto1.updateUI();
        //---------------------
        bordesitosxd = BorderFactory.createLineBorder(new Color(234, 190, 63), 2);
        autor = new JLabel("Diego Parra - Camilo Rozo - David Acero - Jeisson Rincon");
        autor.setBounds(new Rectangle(5, 560, 400, 30));
        autor.setFont(fuente1);
        autor.setBorder(bordesitosxd);
        autor.setForeground(new Color(234, 190, 63));
        autor.setHorizontalAlignment(JLabel.CENTER);
        panelIzquierdo.add(autor);
        //------------------------
        /*
        texto1 = new JLabel("✔ Ingrese un usuario: ");
        texto1.setFont(fuente1);
        texto1.setForeground(new Color(24,118,3));
        texto1.setBounds(getWidth() / 2 + 10, 80, 190, 15);
        panelDerecho.add(texto1);
        texto1.updateUI();
        */
        //------------------------
        bordes = BorderFactory.createLineBorder(new Color(180, 180, 180), 2, false);
        bordes1 = BorderFactory.createLineBorder(new Color(32, 50, 72), 2);
        bordes2 = BorderFactory.createLineBorder(new Color(71, 161, 188), 2);
        
        /*
        caja = new JTextField();
        caja.setBounds(getWidth() / 2 + 10, 45, 300, 27);
        caja.setBorder(bordes);
        caja.setCursor(mano);
        caja.setBackground(new Color(24,118,3));
        caja.setForeground(new Color(235, 196, 56));
        panelDerecho.add(caja);
        caja.updateUI();
        */
        //------------------------
        cerrar = new JButton("x");
        cerrar.setBorder(null);
        cerrar.setFont(fuente);
        cerrar.setContentAreaFilled(false);
        cerrar.setForeground(new Color(24,118,3));
        cerrar.setCursor(mano);
        cerrar.setFocusable(false);
        cerrar.addActionListener(this);
        cerrar.setBounds(1040, 1, 35, 35);
        panelDerecho.add(cerrar);
        cerrar.repaint();
        //------------------------
        operar = new JButton("Aceptar");
        operar.setBounds(getWidth() / 2 + 280, 160, 80, 25);
        operar.setBorder(bordes1);
        operar.setCursor(mano);
        operar.setFont(fuente2);
        operar.setContentAreaFilled(false);
        operar.setForeground(new Color(24,118,3));
        operar.addActionListener(this);
        panelDerecho.add(operar);
        operar.repaint();
        
        //-----------------
        jugar = new JButton("JUGAR");
        jugar.addActionListener(this);
        
        
        pal = new JLabel();
        pal.setBounds(5, 5, 600, 700);
        panelIzquierdo.add(pal);
        String path = "src/imgs/casino.png";
        URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(path);
        String path2 = "src/imgs/dinero3.png";
        URL url2 = this.getClass().getResource(path2);
        ImageIcon icon2 = new ImageIcon(path2);
        pal.setIcon(icon);
        pal.updateUI();
        
        pal2 = new JLabel();
        pal2.setBounds(getWidth() / 2 + 20, 100, 700, 600);
        panelDerecho.add(pal2);
        
       
        pal2.setIcon(icon2);
        pal2.updateUI();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cerrar) {
            System.exit(0);
        }
        if (e.getSource() == operar) {
            if (combo.getSelectedItem().equals("✔ Guayabita")) {
                
                caja = new JTextField();
                caja.setBounds(getWidth() / 2 + 10, 200, 100, 27);
                caja.setBorder(bordes);
                caja.setCursor(mano);
                caja.setBackground(new Color(24, 118, 3));
                caja.setForeground(new Color(235, 196, 56));
                panelDerecho.add(caja);
                ////
                caja2 = new JTextField();
                caja2.setBounds(getWidth() / 2 + 10, 250, 100, 27);
                caja2.setBorder(bordes);
                caja2.setCursor(mano);
                caja2.setBackground(new Color(24, 118, 3));
                caja2.setForeground(new Color(235, 196, 56));
                panelDerecho.add(caja2);
               
                monto = new JLabel("✔ Numero de jugadores ");
                monto.setFont(fuente1);
                monto.setForeground(new Color(24, 118, 3));
                monto.setBounds(getWidth() / 2 + 135, 205, 190, 15);
                panelDerecho.add(monto);
                
                numero = new JLabel("✔ Monto para cada Jugador ");
                numero.setFont(fuente1);
                numero.setForeground(new Color(24, 118, 3));
                numero.setBounds(getWidth() / 2 + 135, 255, 190, 15);
                panelDerecho.add(numero);
                
                
                jugar.setBounds(getWidth() / 2 + 135, 300, 100, 30);
                jugar.setBorder(bordes1);
                jugar.setCursor(mano);
                jugar.setFont(fuente2);
                jugar.setContentAreaFilled(false);
                jugar.setForeground(new Color(24, 118, 3));
                
                panelDerecho.add(jugar);
                jugar.repaint();


                jugar.updateUI();
                numero.updateUI();
                monto.updateUI();
                caja2.updateUI();
                caja.updateUI();
                
                
            }
            
            if(combo.getSelectedItem().equals("✔ Adivina el numero")){
               new Adivina().setVisible(true);
            }
           
        }
        if (e.getSource() == jugar)  {
            Jugador jugador;
            Vector lista=new Vector();
            if (Integer.parseInt(caja.getText()) > 1) {
                for (int i = 1; i <= Integer.parseInt(caja.getText()); i++) {
                    jugador= new Jugador();
                    jugador.setNombre(JOptionPane.showInputDialog("Nombre del Jugador " + i + " ."));
                    jugador.setPuntaje(Integer.parseInt(caja2.getText()));
                    lista.addElement(jugador);
                }
                try{
                vGuayabita g = new vGuayabita(lista,Double.parseDouble(caja2.getText()));
                }catch(NullPointerException u){
                    System.out.println("error prin");
                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Número de jugadores invalido");
            }

        }
        operar.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    System.out.println(""); // ignorar el evento de teclado
                }
            }
        });
    }
}
