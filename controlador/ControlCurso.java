/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.AlmacenCurso;
import modelo.Curso;
import vista.JFrameCurso;
import vista.JFrameReporteCurso;
import vista.JPanelBotones2;
import vista.JPanelDatosCurso;

/**
 *
 * @author Mi compa el alucin
 */
public class ControlCurso implements ActionListener {
    
    private AlmacenCurso almacenCurso;
    private JFrameCurso jFrameCurso;
    private JPanelBotones2 jPanelBotones2;
    private JPanelDatosCurso jPanelDatosCurso; 
    
    
    
    public ControlCurso(JFrameCurso jFrameCurso, JPanelBotones2 jPanelBotones2, JPanelDatosCurso jPanelDatosCurso)
    {
        this.jFrameCurso = jFrameCurso; 
        this.jPanelBotones2 = jPanelBotones2;
        this.jPanelDatosCurso = jPanelDatosCurso; 
        this.almacenCurso = AlmacenCurso.getInstanciaCurso();
        this.jPanelDatosCurso.jButtonBuscar.addActionListener(this);
        this.jPanelBotones2.jButtonAgregar.addActionListener(this);
        this.jPanelBotones2.jButtonModificar2.addActionListener(this);
        this.jPanelBotones2.jButtonEliminar2.addActionListener(this);
        this.jPanelBotones2.jButtonReporte.addActionListener(this);
    }

    public ControlCurso() {
        
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getActionCommand().equalsIgnoreCase("Buscar")){
          String sigla = this.jPanelDatosCurso.jTextFieldSigla.getText();
          Curso curso = this.almacenCurso.buscarCurso(sigla);
          if(curso != null)
          {
              this.jPanelDatosCurso.jTextFieldSigla.setText(curso.getSigla());
              this.jPanelDatosCurso.jTextFieldNombre.setText(curso.getNombre());
              this.jPanelDatosCurso.jTextFieldCreditos.setText(String.valueOf(curso.getCreditos()));
              JOptionPane.showMessageDialog(jFrameCurso, "Registro encontrado: " +sigla);
              
          }else{
          
             JOptionPane.showMessageDialog(jFrameCurso, "No se encontró el curso con la(s) sigla(s):\n ("+sigla+")");
             limpiarPanelDatos();
          }
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Agregar")){
            if(esValidoDatos())
            {
                JOptionPane.showMessageDialog(this.jFrameCurso, 
                        this.almacenCurso.nuevoCurso(crearInstanciaCurso()));
                
                     limpiarPanelDatos();
            }
            
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Modificar")){
            if(esValidoDatos())
            {
               JOptionPane.showMessageDialog(this.jFrameCurso,
                       this.almacenCurso.modificarCurso(crearInstanciaCurso()),
                       "Modificar Curso", 
                       JOptionPane.INFORMATION_MESSAGE);
               limpiarPanelDatos();
            }
                
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Eliminar")){
            String sigla = this.jPanelDatosCurso.jTextFieldSigla.getText();
            Curso curso = this.almacenCurso.buscarCurso(sigla);
            
            if(curso != null)
            {
                int opcion = JOptionPane.showConfirmDialog(jFrameCurso, 
                        "Está de acuerdo en eliminar el curso con la sigla(" +curso.getSigla() +")?"
                        , "Eliminar curso", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                
                if(opcion == 0)
                {
                    JOptionPane.showMessageDialog(this.jFrameCurso, this.almacenCurso.eliminarCurso(curso));
                    limpiarPanelDatos();
                }
            }
             
            
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Reporte")){
            
            JFrameReporteCurso jFrameReporteCurso = new JFrameReporteCurso();
            DefaultTableModel tablaModelo = new DefaultTableModel();
            JTable tablaDatos = jFrameReporteCurso.jPanelTablaCurso1.jTableCurso;
            
            tablaDatos.setModel(this.almacenCurso.getListaCurso(tablaModelo));
            
            jFrameReporteCurso.setVisible(true);
  
        }
                
        
    }
    
     public Curso crearInstanciaCurso()
    {
        Curso curso = new Curso(this.jPanelDatosCurso.jTextFieldSigla.getText(),
                                    this.jPanelDatosCurso.jTextFieldNombre.getText(),
                                        Integer.parseInt(this.jPanelDatosCurso.jTextFieldCreditos.getText()));
        return curso;   
                                        
    }
    
    public boolean esValidoDatos() {
        if (jPanelDatosCurso.jTextFieldSigla.getText().isEmpty()) {
            return false;
        } else if (jPanelDatosCurso.jTextFieldNombre.getText().isEmpty()) {
            return false;
        } else if (jPanelDatosCurso.jTextFieldCreditos.getText().isEmpty()) {
            return false;
        } else{
            return true;
        }
    }
    
    public void limpiarPanelDatos() {
        this.jPanelDatosCurso.jTextFieldSigla.setText("");
        this.jPanelDatosCurso.jTextFieldNombre.setText("");
        this.jPanelDatosCurso.jTextFieldCreditos.setText("");
    } 
    
 
}
