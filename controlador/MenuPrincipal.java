/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import vista.JFrameCurso;
import vista.JFrameEstudiante;
import vista.JFramePrincipal;

/**
 *
 * @author mag
 */
public class MenuPrincipal implements ActionListener{
    private JFramePrincipal jFramePrincipal;
    private JMenuItem jMenuItemSalir;
    private JMenuItem jMenuItemEstudiante;
    private JMenuItem jMenuItemCurso;

    public MenuPrincipal(JFramePrincipal jFramePrincipal) {
        this.jFramePrincipal = jFramePrincipal;
        this.jMenuItemSalir = jFramePrincipal.jMenuItemSalir;
        this.jMenuItemEstudiante = jFramePrincipal.jMenuItemEstudiante;
        this.jMenuItemCurso = jFramePrincipal.jMenuItemCurso;
        this.jMenuItemSalir.addActionListener(this);
        this.jMenuItemEstudiante.addActionListener(this);
        this.jMenuItemCurso.addActionListener(this);
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("salir")){
            int opcion = JOptionPane.showConfirmDialog(
                    null, 
                    "Desea salir del sistema?", 
                    "Confirmación", 
                    JOptionPane.YES_NO_OPTION);
            if(opcion==JOptionPane.YES_NO_OPTION){
                System.exit(0);
            }
        }
        if(e.getActionCommand().equalsIgnoreCase("estudiante")){
            JFrameEstudiante jFrameEstudiante = new JFrameEstudiante();
            jFrameEstudiante.setVisible(true);
        }
        if(e.getActionCommand().equalsIgnoreCase("curso")){
            JFrameCurso jFrameCurso = new JFrameCurso();
            jFrameCurso.setVisible(true);
            
        }
        
    }
    
}
