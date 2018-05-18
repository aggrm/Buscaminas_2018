/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;


import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author xp
 */
public class Boton extends JButton{
    
    private int mina = 0;
    private int i = 0;
    private int j = 0;
    private int numeroMinasAlrededor = 0;

    public Boton (int _i, int _j){
        i = _i;
        j = _j;
        //this.setBorder(null);
        this.setFocusPainted(false);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        //this.setImagen(0);                                                      //para que aparezca sin las minas
        
    }
    
    public int getJ() {
        return j;
    }

    public int getI() {
        return i;
    }

    public int getMina() {
        return mina;
    }

    public void setMina(int mina) {
        this.mina = mina;
    }

    public int getNumeroMinasAlrededor() {
        return numeroMinasAlrededor;
    }

    public void setNumeroMinasAlrededor(int numeroMinasAlrededor) {
        this.numeroMinasAlrededor = numeroMinasAlrededor;
    }
    
    public void setImagen(int num){   
        String nombre = "";
     
        switch (num){
            case 0:
                nombre = "blank";                                               //Por defecto la casilla
                break;
            case 1:
                nombre = "number1";                                             //Número 1
                break;
            case 2:
                nombre = "number2";                                             //Número 2
                break;
            case 3:
                nombre = "number3";                                             //Número 3
                break;
            case 4:
                nombre = "number4";                                             //Número 4
                break;
            case 5:
                nombre = "number5";                                             //Número 5
                break;
            case 6:
                nombre = "number6";                                             //Número 6
                break;
            case 7:
                nombre = "number7";                                             //Número 7
                break;
            case 8:
                nombre = "number8";                                             //Número 8
                break;
            case 9:
                nombre = "flag";                                                //Bandera
                break;
            case 10:
                nombre = "exposed";                                             //Casilla al darle
                break;
            case 11:
                nombre = "expose";                                              //Mina explotada
                break;
            
        }
        String ruta = "/imagenes/" + nombre + ".png";
        this.setIcon(new ImageIcon(getClass().getResource(ruta)));
    }
    
    
}