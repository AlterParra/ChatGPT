/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication11;

import controlador.MenuPrincipal;
import vista.JFramePrincipal;

/**
 *
 * @author mag
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFramePrincipal jFramePrincipal = new JFramePrincipal();
        MenuPrincipal menuPrincipal = new MenuPrincipal(jFramePrincipal);
        jFramePrincipal.setVisible(true);
    }
    
}
