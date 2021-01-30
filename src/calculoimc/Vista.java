
package calculoimc;
import java.awt.*;
import javax.swing.*;

public class Vista extends JFrame {
    
    JTextField nss;
    JTextField peso;
    JTextField imc;
    JTextField nombre;
    JTextField altura;
    JTextField clasificacion;
    JLabel e1;
    JLabel e2;
    JLabel e3;
    JLabel e4;
    JLabel e5;
    JLabel e6;
    JButton calcular;
    JButton borrar;
    JButton guardar;
    JPanel c1, c2,c3,c4 ;
    JPanel superior, inferior;
    
    public Vista(){
        //Etiquetas de texto
        nss = new JTextField("",6);
        peso = new JTextField("",6);
        imc = new JTextField("",20);
        nombre = new JTextField("",6);
        altura = new JTextField("",6);
        clasificacion = new JTextField("",6);
        e1 = new JLabel("NSS:");
        e2 = new JLabel("Peso:");
        e3 = new JLabel("IMC:");
        e4 = new JLabel("Nombre:");
        e5 = new JLabel("Altura:");
        e6 = new JLabel("Clasificacion:");
        //Botones
        calcular = new JButton("Calcular");
        borrar = new JButton("Limpiar");
        guardar = new JButton("Guardar");
        //Paneles
        c1 = new JPanel();
        c2 = new JPanel();
        c3 = new JPanel();
        c4 = new JPanel();
        superior = new JPanel();
        inferior = new JPanel();
        
        setDiseño();
        addComponentes();
        setComponentes();
        setVentana();
        
        
    }
     public void setComponentes(){
        imc.setEditable(false);
        clasificacion.setEditable(false);       
        
           
    }
    public void setDiseño(){
        c1.setLayout(new GridLayout(3,1));
        c2.setLayout(new GridLayout(3,1));
        c3.setLayout(new GridLayout(3,1));
        c4.setLayout(new GridLayout(3,1));
        superior.setLayout(new GridLayout(1,4));
        inferior.setLayout(new GridLayout(1,2));
        this.setLayout(new BorderLayout());
    }
    public void addComponentes(){
        c1.add(e1);
        c1.add(e2);
        c1.add(e3);
        c2.add(nss);
        c2.add(peso);
        c2.add(imc);
        c3.add(e4);
        c3.add(e5);
        c3.add(e6);
        c4.add(nombre);
        c4.add(altura);
        c4.add(clasificacion);
       
     
        superior.add(c1);
        superior.add(c2);
        superior.add(c3);
        superior.add(c4);
        inferior.add(calcular);
        inferior.add(borrar);
        inferior.add(guardar);
        
        this.add(superior,BorderLayout.NORTH);
        this.add(inferior,BorderLayout.SOUTH);
    }
    public void setVentana(){
        this.setVisible(true);
        this.setTitle("Calculo de IMC");
        this.setSize(650, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    
}
