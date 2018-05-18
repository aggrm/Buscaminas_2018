/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author xp
 */
public class VentanaBuscaminas extends javax.swing.JFrame {

    int filas = 15; 
    int columnas = 20;
    int numeroMinas = 30;
    
    String numero;
    
    Boton [][] arrayBotones = new Boton [filas][columnas];
    public VentanaBuscaminas() {
        initComponents();
        setSize(27*columnas , 29*filas);
        setTitle("Buscaminas de Alberto Goujon");
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridLayout(filas, columnas));
        for (int i=0; i<filas; i++){
            for (int j=0; j<columnas; j++){
                Boton boton = new Boton(i, j);
                
                getContentPane().add(boton);
                arrayBotones[i][j] = boton;
                boton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent evt){
                        botonPulsado(evt);
                    }
                });
            }
        }
        ponMinas(numeroMinas);
        cuentaMinas();
    }
    
    
    private void botonPulsado(MouseEvent e){
        Boton miBoton = (Boton) e.getComponent();
        if (e.getButton() == MouseEvent.BUTTON3 && miBoton.isEnabled()){
            miBoton.setImagen(9);
        }
                
         if (e.getButton() == MouseEvent.BUTTON1 && miBoton.isEnabled()){ 
             buscamina(miBoton);
             
            if(arrayBotones[miBoton.getI()][miBoton.getJ()].
                    getNumeroMinasAlrededor() > 0)
            {
                                        
              numero = String.valueOf(arrayBotones[miBoton.getI()]
                      [miBoton.getJ()].getNumeroMinasAlrededor());
              miBoton.setImagen(Integer.parseInt(numero));
            }
            if(arrayBotones[miBoton.getI()]
                            [miBoton.getJ()].getMina() == 1)
             {
                miBoton.setImagen(11);
                miBoton.setEnabled(true);                                  
                JOptionPane.showMessageDialog(null, "Has perdido!! Juega otra vez");
                getContentPane().setEnabled(false);
             }
             
        }
         
    }
    private void buscamina(Boton boton) 
    {
        if (boton.getNumeroMinasAlrededor() == 0) 
        {
            for (int k = -1; k < 2; k++) 
            {
                for (int m = -1; m < 2; m++) 
                {
                    if ((boton.getI() + k >= 0) && (boton.getJ() + m >= 0)
                            && (boton.getI() + k < filas)
                            && (boton.getJ() + m < columnas)) 
                    {
                        if (arrayBotones[boton.getI() + k][boton.getJ() + m].
                                isEnabled()) 
                        {
                            if (arrayBotones[boton.getI() + k][boton.getJ() + m]
                                    .getNumeroMinasAlrededor() == 0) {
                                arrayBotones[boton.getI() + k][boton.getJ() + m]
                                        .setEnabled(false);
                                buscamina(arrayBotones[boton.getI() + k]
                                        [boton.getJ() + m]);
                            } 
                            else 
                            {
                                arrayBotones[boton.getI() + k][boton.getJ() + m].
                                        setImagen(arrayBotones[boton.getI() + k]
                                                [boton.getJ() + m].
                                                getNumeroMinasAlrededor());
                            }
                        }
                    }
                }
            }

        }
    }
     private void ponMinas(int numeroMinas){
        Random r = new Random();
        for (int i=0; i<numeroMinas; i++)
        {
            int f = r.nextInt(filas);
            int c = r.nextInt(columnas);
            
            if (arrayBotones[f][c].getMina() == 0) {
	    arrayBotones[f][c].setMina(1);
//            arrayBotones[f][c].setText("m");                                    //Version con numeros
	} else {
	    ponMinaEnOtroLugar();
	}

            
            
        }
    }
     
      private void ponMinaEnOtroLugar() {                                       //Metodo para que no ponga minas donde ya las tenia puestas, a parte no le pongo parametro de entrada
	Random r = new Random();
	int f = r.nextInt(filas);
	int c = r.nextInt(columnas);
	if (arrayBotones[f][c].getMina() == 0) {
	    arrayBotones[f][c].setMina(1);
//            arrayBotones[f][c].setText("m");                                    //Version con numeros
	} else {
	    ponMinaEnOtroLugar();
	}
    }

     
    
    
    private void cuentaMinas(){                                                 //Este metodo es un metodo para cada boton calcula el número de minas que tiene alrededor
        int minas = 0;
        for (int i=0; i<filas; i++){
            for (int j=0; j<columnas; j++)
            {
                for (int k=-1; k<2; k++)
                {
                    for(int m=-1; m<2; m++)
                    {
                        if ((i+k >= 0) && (j+m >= 0)&&(i+k < filas) 
                                && (j+m <columnas))
                        {
                            minas = minas + arrayBotones[i+k][j+m].getMina();
                        }
                    }
                }
                arrayBotones[i][j].setNumeroMinasAlrededor(minas);
                
                if (arrayBotones[i][j].getMina() == 0){
                    //arrayBotones[i][j].setText(String.valueOf(minas));        version con los números
                    arrayBotones[i][j].setImagen(0);
                }
                
                minas = 0;

                
            }
        }
    }
     /**
     * Creates new form VentanaBuscaminas
     */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscaminas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscaminas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscaminas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBuscaminas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaBuscaminas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
