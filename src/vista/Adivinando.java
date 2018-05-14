package vista;
import javax.swing.*;
import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.*;
import java.net.URL;
import javax.swing.border.Border;

class Adivina extends JFrame implements ActionListener
{
    private JPanel panelIzquierdo, panelDerecho;
    JTextField t1, t2, t3, t4;
    JLabel j4; 
    ButtonListener bl1;
    ButtonListener2 bl2;
    ButtonListener3 bl3;  
    
    private JLabel texto, autor, pal,pal2;
    private JButton cerrar, operar;
    private Font fuente, fuente1, fuente2;
    private Cursor mano;
    private Border bordesitosxd, bordes1;
    private int contador=0;
    private String valor1 = "";


    //se crea la variable aleatoria
    
    int rand=(int) (Math.random()*100); 
     
    
    int count=0;

    
    public Adivina()
    {

        Container c = getContentPane();
   
        c.setLayout(null);   

        c.setBackground(Color.WHITE); 

        JLabel lblpic = new JLabel("");
        lblpic.setIcon(new ImageIcon("images.png"));
        lblpic.setBounds(0,0,500,350);

        JLabel j=new JLabel("ADIVINA EL NUMERO");
        j.setForeground(Color.WHITE);
        j.setFont(new Font("Berlin Sans FB", Font.BOLD, 25));
        j.setSize(300,20);
        j.setLocation(700,40);

        //Crea label para ingresar un numero.. 
        JLabel j1=new JLabel("Ingresa un numero de 1-100");
        j1.setFont(new Font("Berlin Sans FB", Font.BOLD, 15));
        j1.setSize(300,20);
        j1.setLocation(680,80);

        //Crea Textfield para ingresar el valor
        t1=new JTextField(10);
        t1.setSize(50,30);
        t1.setLocation(770,120);

        //Crea label para mostrar el mensaje       
        j4=new JLabel("INTENTA ADIVINAR EL NUMERO");
        j4.setForeground(Color.WHITE);
        j4.setFont(new Font("Berlin Sans FB", Font.BOLD, 16));
        j4.setSize(310,20);
        j4.setLocation(700,170);

        //Crea Textfield para mostrar puntaje mas alto
        t2=new JTextField(10);
        t2.setSize(40,20);
        t2.setLocation(1000,555);        

        //Crea label para mejor puntaje
        JLabel j5=new JLabel("Mejor Puntaje");
        j5.setForeground(Color.WHITE);
        j5.setFont(new Font("Berlin Sans FB", Font.BOLD, 25));
        j5.setSize(290,32);
        j5.setLocation(800,550);

        //crea campo de texto para los intentos
        t3=new JTextField(10);
        t3.setSize(40,20);
        t3.setLocation(800,350);

        //Crea label de intentos
        JLabel j6=new JLabel("Intentos");
        j6.setForeground(Color.WHITE);
        j6.setFont(new Font("Berlin Sans FB", Font.BOLD, 25));
        j6.setSize(270,20);
        j6.setLocation(670,350);

        //crea los tres botones
        JButton b1=new JButton("Intentar");
        b1.setSize(150,40);
        b1.setLocation(720,250);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Berlin Sans FB", Font.BOLD, 18));
        bl1=new ButtonListener();        
        b1.addActionListener(bl1);


        JButton b2=new JButton("Rendirme");
        b2.setSize(140,30);
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Berlin Sans FB", Font.BOLD, 18));
        b2.setLocation(900,500);
        bl2=new ButtonListener2();
        b2.addActionListener(bl2);        

        JButton b3=new JButton("Jugar De Nuevo");
        b3.setForeground(Color.BLACK);
        b3.setFont(new Font("Berlin Sans FB", Font.BOLD, 18));
        b3.setSize(200,30);
        b3.setLocation(600,500);    
        bl3=new ButtonListener3();        
        b3.addActionListener(bl3);
        c.add(j5);    
        c.add(j4);    
        c.add(lblpic);
        c.add(j);    
        c.add(j1);
        c.add(t1);
        c.add(t2);
        c.add(t3);
        c.add(b1);    
        c.add(b2);
        c.add(b3);        
        c.add(j6);     

        //cambia los jtext para no editarlos
        t2.setEditable(false);
        t3.setEditable(false);    

        //Titulo de ventana
        setTitle("ADIVINA EL NUMERO");        

        //tamaños y demas
         setSize(1100, 650);
        setVisible(true);
        Panel1();
        Panel2();
        Componentes();
         
        setResizable(false);
//        setUndecorated(false);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
       
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
        texto = new JLabel("$Adivina El Número$");
        texto.setFont(fuente);
        texto.setBounds(getWidth() / 2 -500, getHeight() / 2 - 150, 450, 30);
        texto.setForeground(new Color(234, 190, 63));
        panelIzquierdo.add(texto);
        //------------------------
        bordesitosxd = BorderFactory.createLineBorder(new Color(234, 190, 63), 2);
        autor = new JLabel("Diego Parra - Camilo Rozo - David Acero - Jeisson Rincon");
        autor.setBounds(new Rectangle(5, 560, 400, 30));
        autor.setFont(fuente1);
        autor.setBorder(bordesitosxd);
        autor.setForeground(new Color(234, 190, 63));
        autor.setHorizontalAlignment(JLabel.CENTER);
        panelIzquierdo.add(autor);
        bordes1 = BorderFactory.createLineBorder(new Color(32, 50, 72), 2);
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

        panelDerecho.add(operar);
        operar.repaint();
        
        //-----------------
  
 
        
        
        pal = new JLabel();
        pal.setBounds(5, 5, 600, 700);
        panelIzquierdo.add(pal);
        String path = "src/imgs/num.gif";
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
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private class ButtonListener implements ActionListener
    {
        int bestScore=100;
        public void actionPerformed(ActionEvent e)
        {
            int a = Integer.parseInt(t1.getText());
            count=count+1;
            if(count<5){
            if(a<rand)
            {
                j4.setText(a+" MUY PEQUEÑO");
            }    
            else if(a>rand)
            {
                j4.setText(a+" Muy arriba sigue intentando!");
            }
            else
            {
                j4.setText("Correcto Ganaste!!!!");    
                if(count<bestScore)
                {    
                    bestScore=count;
                    t2.setText(bestScore+"");
                }
                else
                    t2.setText(""+bestScore);
                    t1.setEditable(false);
            }

            //setting focus to input guess text field
            t1.requestFocus();
            t1.selectAll();

            t3.setText(count+"");
        }
            else {
                j4.setText("PERDISTE");
                t3.setText(count+"");
                t1.setEditable(false);
            }
        }
    }

    private class ButtonListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            t3.setText("");
            j4.setText(rand+" Es la respuesta!");
            t1.setText("");
            t1.setEditable(false);
            
        }
    }        

    private class ButtonListener3 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            rand=(int) (Math.random()*100);
            t1.setText("");
            t3.setText("");
            j4.setText("Intenta y adivina el numero");
            t3.setText("");
            count=0;
            t1.setEditable(true);    
            t1.requestFocus();
        }
    }

}