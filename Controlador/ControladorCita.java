/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.AlmacenCita;
import Modelo.Cita;
import Vista.JFrameCita;
import Vista.JPanelBotones;
import Vista.JPanelDatosCita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Soporte
 */
public class ControladorCita implements ActionListener{
    
    //Atributos
    JFrameCita jFrameCita;
    JPanelDatosCita jPanelDatosCita;
    JPanelBotones jPanelBotones;
    AlmacenCita almacenCita;
    

    public ControladorCita(JFrameCita jFrameCita, JPanelDatosCita jPanelDatosCita, JPanelBotones jPanelBotones) {
        this.jFrameCita = jFrameCita;
        this.jPanelDatosCita = jPanelDatosCita;
        this.jPanelBotones = jPanelBotones;
        this.almacenCita = AlmacenCita.getInstancia();
        this.jPanelBotones.jButtonBuscar.addActionListener(this);
        this.jPanelBotones.jButtonAgregar.addActionListener(this);
        this.jPanelBotones.jButtonModificar.addActionListener(this);
        this.jPanelBotones.jButtonEliminar.addActionListener(this);
        
    }

    
     
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getActionCommand().equalsIgnoreCase("Buscar"))
        {
            if(!jPanelDatosCita.jTextFieldPaciente.getText().isEmpty())
            {
                 String paciente = jPanelDatosCita.jTextFieldPaciente.getText();
                 if(almacenCita.buscarCita(paciente) != null)
                 {
                 
                    Cita cita = almacenCita.buscarCita(paciente);
                    jPanelDatosCita.jTextFieldFecha.setText(cita.getFecha());
                    jPanelDatosCita.jTextFieldHora.setText(String.valueOf(cita.getHora()));
                    jPanelDatosCita.jTextFieldEspecialidad.setText(cita.getEspecialidad());
                    jPanelDatosCita.jTextFieldMedico.setText(cita.getMedico());
                    jPanelDatosCita.jTextFieldPaciente.setText(cita.getPaciente());
                    
                 }else{
                 
                     JOptionPane.showMessageDialog(jFrameCita, "No existe una cita registrada a ese nombre de paciente");
                     
                 }
                        
            }
            else
                JOptionPane.showMessageDialog(jFrameCita, "Para buscar una cita debe llenar el campo del nombre del paciente");
                
            
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Agregar"))
        {
            if(esValidoDatos() == true)
            {
                JOptionPane.showMessageDialog(jFrameCita, almacenCita.agregarCita(getInstanciaCita()));    
                limpiarDatos();
            }
            
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Modificar"))
        {
            if(esValidoDatos() == true)
            {
                JOptionPane.showMessageDialog(jFrameCita, almacenCita.ModificarCita(getInstanciaCita()));
            }
            
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Eliminar"))
        {
            if(esValidoDatos() == true)
            {
                Cita cita = almacenCita.buscarCita(jPanelDatosCita.jTextFieldPaciente.getText());
                
                int opcion = JOptionPane.showConfirmDialog(jFrameCita,
                        "Está segur@ de que desea eliminar esta cita?", 
                        "Eliminar cita", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE);
                
                if(opcion == 0)
                {
                    JOptionPane.showMessageDialog(jFrameCita, almacenCita.eliminarCita(cita));
                }
                
                limpiarDatos();
                  
            }
            
        }
            
    }
    
    public boolean esValidoDatos()
    {
        if(jPanelDatosCita.jTextFieldFecha.getText().isEmpty())
            return false; 
        else if(jPanelDatosCita.jTextFieldHora.getText().isEmpty())
            return false;
        else if(jPanelDatosCita.jTextFieldEspecialidad.getText().isEmpty())
            return false;
        else if(jPanelDatosCita.jTextFieldMedico.getText().isEmpty())
            return false;
        else if(jPanelDatosCita.jTextFieldPaciente.getText().isEmpty())
            return false;
        else
            return true;
    }
    
    
    public Cita getInstanciaCita()
    {
        Cita cita = new Cita(jPanelDatosCita.jTextFieldFecha.getText(),
                Integer.parseInt(jPanelDatosCita.jTextFieldHora.getText()),
                jPanelDatosCita.jTextFieldEspecialidad.getText(),
                jPanelDatosCita.jTextFieldMedico.getText(),
                jPanelDatosCita.jTextFieldPaciente.getText()
        );
            
        return cita;
        
    }
    
    public void limpiarDatos()
    {
        if(esValidoDatos() == true)
        {
            jPanelDatosCita.jTextFieldFecha.setText("");
            jPanelDatosCita.jTextFieldHora.setText("");
            jPanelDatosCita.jTextFieldEspecialidad.setText("");
            jPanelDatosCita.jTextFieldMedico.setText("");
            jPanelDatosCita.jTextFieldPaciente.setText("");
        }
    }
     
     
     
  
    
}
