package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import modelo.Dado;
import modelo.Jugador;
import sun.security.util.SecurityConstants.AWT;

public class vGuayabita extends JFrame implements ActionListener {

    //private JTextField caja;
    private JLabel texto, texto1,texto2, autor, pal, pal2, nopal, contarL, contarP, eliminar;
    private JButton cerrar, operar;
    private JComboBox combo;
    private JPanel panelIzquierdo, panelDerecho;
    private Font fuente, fuente1, fuente2;
    private Cursor mano;
    private Border bordesitosxd, bordes, bordes1, bordes2;
    private StringTokenizer st;
    //-----------------
    private int contador = 0;
    private String valor;
    private String valor1 = "";
    private char[] arrayChar;
    //---------------------
    private Vector jugadores, nuevaLista;
    private double vMesa;
    public int turnos, turno;
    public Jugador jug = new Jugador();



    public vGuayabita(Vector list, double mesa) {   // Creacion de la ventana 
        jugadores = list;
        turnos = jugadores.size() ;
        vMesa = jugadores.size();
        turno = 0;
        
        for (int i = 0; i < jugadores.size(); i++) {
            jug=(Jugador)jugadores.elementAt(i);
            jug.setPuntaje(jug.getPuntaje()-1);
        }
          
        
        
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
        combo.setBackground(new Color(24, 118, 3));
        combo.setForeground(new Color(235, 196, 56));
        combo.addActionListener(this);
        //panelDerecho.add(combo);
        combo.updateUI();

    }

    public void Panel1() {
        // Creacion del JPanel Izquierda
        panelIzquierdo = new JPanel();
        panelIzquierdo.setBounds(0, 0, getWidth() / 2, getHeight());
        panelIzquierdo.setBackground(new Color(124, 6, 0));
        panelIzquierdo.setLayout(null);
        this.add(panelIzquierdo);
        panelIzquierdo.updateUI();
    }

    public void Panel2() {
        // Creacion del JPanel Derecho
        panelDerecho = new JPanel();
        panelDerecho.setBounds(getWidth() / 2, 0, getWidth(), getHeight());
        panelDerecho.setBackground(new Color(165, 209, 133));
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
        texto = new JLabel("$$$.GUAYABITA.$$$");
        texto.setFont(fuente);
        texto.setBounds(getWidth() / 2 - 460, getHeight() / 2 - 150, 400, 30);
        texto.setForeground(new Color(234, 190, 63));
        panelIzquierdo.add(texto);
        //------------------------

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
        jug = (Jugador) jugadores.elementAt(turno);
        texto1 = new JLabel("Turno de: " + jug.getNombre()+" \n Credito="+jug.getPuntaje());
        texto1.setFont(fuente2);
        texto1.setForeground(new Color(24, 118, 3));
        texto1.setBounds(getWidth() / 2 + 10, 80, 500, 35);
        panelDerecho.add(texto1);
        texto1.updateUI();

        //------------------------
        jug = (Jugador) jugadores.elementAt(turno);
        texto2 = new JLabel("$ En la mesa: " + (int)vMesa);
        texto2.setFont(fuente2);
        texto2.setForeground(new Color(24, 118, 3));
        texto2.setBounds(getWidth() / 2 + 10, 120, 500, 35);
        panelDerecho.add(texto2);
        texto2.updateUI();
        
        //-----------------------
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
        cerrar.setForeground(new Color(24, 118, 3));
        cerrar.setCursor(mano);
        cerrar.setFocusable(false);
        cerrar.addActionListener(this);
        cerrar.setBounds(1040, 1, 35, 35);
        panelDerecho.add(cerrar);
        cerrar.repaint();
        //------------------------
        operar = new JButton("Lanzar dado");
        operar.setBounds(getWidth() / 2 + 280, 160, 150, 25);
        operar.setBorder(bordes1);
        operar.setCursor(mano);
        operar.setFont(fuente2);
        operar.setContentAreaFilled(false);
        operar.setForeground(new Color(24, 118, 3));
        operar.addActionListener(this);
        panelDerecho.add(operar);
        operar.repaint();

        pal = new JLabel();
        pal.setBounds(200, 0, 600, 700);
        panelIzquierdo.add(pal);
        String path = "src/imgs/dado3.gif";
        URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(path);
        String path2 = "src/imgs/coins.png";
        URL url2 = this.getClass().getResource(path2);
        ImageIcon icon2 = new ImageIcon(path2);
        pal.setIcon(icon);
        pal.updateUI();

        pal2 = new JLabel();
        pal2.setBounds(getWidth() / 2 + 300, 180, 700, 600);
        panelDerecho.add(pal2);

        pal2.setIcon(icon2);
        pal2.updateUI();

    }
    public boolean validaPuntajes(){
        boolean val=false;
        for (int i = 0; i < jugadores.size(); i++) {
            jug=(Jugador)jugadores.elementAt(i);
            if(jug.getPuntaje()!=0){
                val=true;
            }
        }
        return val;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String path3 = "src/coin.png";
        URL url3 = this.getClass().getResource(path3);
        ImageIcon icon3 = new ImageIcon(path3);
        if (e.getSource() == operar) {
            Dado d = new Dado();
            if (vMesa > 0 && validaPuntajes()) {
                int na = d.na();
                String path = "src/imgs/" + na + ".png";
                URL url = this.getClass().getResource(path);
                ImageIcon icon = new ImageIcon(path);
                pal.setIcon(icon);
                if (turno < jugadores.size() ) {//valida si llego al fin  de la lista
                    jug = (Jugador) jugadores.elementAt(turno);
                    texto1.setText("*TURNO DE:  " + jug.getNombre() + " \n Credito=" + jug.getPuntaje());
                    texto2.setText("$ En la mesa: " + (int) vMesa);
                    texto1.updateUI();
                    texto2.updateUI();
                    jug = (Jugador) jugadores.elementAt(turno);

                    if (na == 1 || na == 6) {
                        if (jug.getPuntaje() == 0) {

                        } else {
                            jug.setPuntaje(jug.getPuntaje() - 1);
                            vMesa = vMesa + 1;
                        }
                    } else {
                        if (jug.getPuntaje() > 0) {
                            int apuesta = Integer.parseInt(JOptionPane.showInputDialog(null, jug.nombre+" Su número es " + na + ". ¿Cuanto desea apostar?"));
                            int nuAnterior=na;
                            //nuevo numero para apostar
                            na = d.na();
                            path = "src/imgs/" + na + ".png";
                            url = this.getClass().getResource(path);
                            icon = new ImageIcon(path);
                            pal.setIcon(icon);
                            pal.updateUI();
                            if(na>nuAnterior){
                                JOptionPane.showMessageDialog(null, "Gano");
                                jug.setPuntaje(jug.getPuntaje()+apuesta);
                                vMesa=vMesa-apuesta;
                            }else{
                                JOptionPane.showMessageDialog(null, "Perdio");
                                jug.setPuntaje(jug.getPuntaje()-apuesta);
                                vMesa=vMesa+apuesta;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No puede apostar");
                        }
                    }

                    turno++;
                } else {// reinicia recorrio de la lista
                    turno = 0;
                    JOptionPane.showMessageDialog(null, "..SIGUIENTE RONDA..");

                }
                   
            } else {
                JOptionPane.showMessageDialog(null, "FIN DEL JUEGO");
            }

        }
         if (e.getSource() == cerrar) {
            this.setVisible(false);
        }
        operar.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {

                }
            }
        });
    }
}
