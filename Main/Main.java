/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controlador.MenuPrincipal;
import Vista.JFramePrincipal;

/**
 *
 * @author Soporte
 */
public class Main {
    
    public static void main(String args[])
    {       
        JFramePrincipal vista = new JFramePrincipal();
        MenuPrincipal menu = new MenuPrincipal(vista);
        vista.setVisible(true);
          
    }
    
    
}
