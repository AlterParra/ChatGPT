/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.JFrameCita;
import Vista.JFramePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Soporte
 */
public class MenuPrincipal implements ActionListener{
    
    private JFramePrincipal vista;
   
    public MenuPrincipal(JFramePrincipal vista) {
        this.vista = vista;
        this.vista.jMenuItemSalir.addActionListener(this);
        this.vista.jMenuItemCita.addActionListener(this);
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    
        
        if(e.getActionCommand().equalsIgnoreCase("Cerrar la ventana")){
            int opcion = JOptionPane.showConfirmDialog(vista, 
                    "Desea cerrar el sistema?", 
                    "Confirmación", 
                    JOptionPane.YES_NO_OPTION);
            
            if(opcion == 0)
                System.exit(0);
              
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Gestionar Cita"))
        {    
            JFrameCita jFrameCita = new JFrameCita();
            jFrameCita.setVisible(true);
            
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Guardar en archivo csv"))
        {
           
            
            
        }
        
    
    } 
    
}
