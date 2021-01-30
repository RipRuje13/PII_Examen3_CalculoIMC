package calculoimc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Controlador {

    Vista v1;
    IMC imc1;
    int i = 0;
    PrintWriter out = null;

    public Controlador() {
        v1 = new Vista();
        v1.calcular.addActionListener(new ObjetoEscuchaCalcular());
        v1.borrar.addActionListener(new ObjetoEscuchaBorrar());
        v1.guardar.addActionListener(new ObjetoEscuchaGuardar());
    }

    public class ObjetoEscuchaCalcular implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nss1, nom1, peso1, altura1, clasificacion;
            int nss2;
            double peso2, altura2, imc;

            
                try {
                    try {
                        try {

                            nss1 = v1.nss.getText();
                            nom1 = v1.nombre.getText();
                            peso1 = v1.peso.getText();
                            altura1 = v1.altura.getText();

                            nss2 = Integer.parseInt(nss1);
                            peso2 = Double.parseDouble(peso1);
                            altura2 = Double.parseDouble(altura1);

                            imc1 = new IMC(nss2, nom1, peso2, altura2);

                            imc = imc1.calcularImc();
                            clasificacion = imc1.categoria();

                            v1.imc.setText(Double.toString(imc));
                            v1.clasificacion.setText(clasificacion);
                            
                        } catch (NumeroIncorrecto e3) {
                            JOptionPane.showMessageDialog(null, "Numero de NSS Incorrecto. El  nss debe ser de 5 digitos", "Error", JOptionPane.PLAIN_MESSAGE);
                        }
                    } catch (ArithmeticException e2) {
                        JOptionPane.showMessageDialog(null, "Peso no valido. ", "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (ArithmeticException e1) {
                    JOptionPane.showMessageDialog(null, "Altura no valida. ", "Error", JOptionPane.PLAIN_MESSAGE);
                }

             catch (NumberFormatException e5) {
                JOptionPane.showMessageDialog(null, "Usted debe proporcionar sus datos en las cajas de texto.", "Error", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public class ObjetoEscuchaBorrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            limpiarCajasTexto();
        }
    }

    public class ObjetoEscuchaGuardar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            escribirArchivo(imc1);

        }

    }

    public void limpiarCajasTexto() {
        v1.nss.setText("");
        v1.nombre.setText("");
        v1.peso.setText("");
        v1.altura.setText("");
        v1.imc.setText("");
        v1.clasificacion.setText("");
    }

    public void escribirArchivo(IMC imcp) {
        IMC imc = imcp;
        String NombreA = imc.getNss() + "";

        try {
            FileWriter escribir = new FileWriter(NombreA, true);
            out = new PrintWriter(escribir);
            out.write(imc.toString()+"\n");
            //out.append(NombreA);
        } catch (FileNotFoundException e) {
            System.out.println("\nNo se pudo crear\n");
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (out != null) {
                out.close();
               
            }
        }

    }

}
