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
import modelo.AlmacenEstudiante;
import modelo.Estudiante;
import vista.JFrameEstudiante;
import vista.JFrameReporteEstudiante;
import vista.JPanelBotones;
import vista.JPanelDatosEstudiante;

/**
 *
 * @author mag
 */
public class ControlEstudiante implements ActionListener {

    private JFrameEstudiante jFrameEstudiante;
    private JPanelDatosEstudiante jPanelDatosEstudiante;
    private JPanelBotones jPanelBotones;
    private AlmacenEstudiante almacenEstudiante;
//Constructor de ControlEstudiante

    public ControlEstudiante(JFrameEstudiante jFrameEstudiante,
            JPanelDatosEstudiante jPanelDatosEstudiante,
            JPanelBotones jPanelBotones) {
        this.jFrameEstudiante = jFrameEstudiante;
        this.jPanelDatosEstudiante = jPanelDatosEstudiante;
        this.jPanelBotones = jPanelBotones;
        this.almacenEstudiante = AlmacenEstudiante.getInstancia();
        this.jPanelBotones.jButtonCrear.addActionListener(this);
        this.jPanelDatosEstudiante.jButtonBuscar.addActionListener(this);
        this.jPanelBotones.jButtonModificar.addActionListener(this);
        this.jPanelBotones.jButtonEliminar.addActionListener(this);
        this.jPanelBotones.jButtonListar.addActionListener(this);
    }
    

    @Override //ActionPerformed, acciones realizadas
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Crear")) {
            if (esValidoDatos()) {
                JOptionPane.showMessageDialog(
                        this.jFrameEstudiante,
                        this.almacenEstudiante.crearEstudiante(crearInstanciaEstudiante()));//Este metodo nos crea una instancia de estudiante sin tener que repertir demasiado
                limpiarPanelDatos();
            }
        }

        if (e.getActionCommand().equalsIgnoreCase("buscar")) {
            
            String carne = this.jPanelDatosEstudiante.jTextFieldCarne.getText();
            Estudiante estudiante = this.almacenEstudiante.buscarEstudiante(carne);
            if (estudiante != null) {
                this.jPanelDatosEstudiante.jTextFieldNombre.setText(estudiante.getNombre());
                JOptionPane.showMessageDialog(this.jFrameEstudiante, "Registro encontrado: " + carne);
            } else {
                JOptionPane.showMessageDialog(this.jFrameEstudiante, "No se encontro registro con el numero de carne (" + carne + ")");
                limpiarPanelDatos();
            }
        }

        if (e.getActionCommand().equalsIgnoreCase("Modificar")) {
            if (esValidoDatos()) {
                JOptionPane.showMessageDialog(
                        this.jFrameEstudiante,
                        this.almacenEstudiante.modificarEstudiante(crearInstanciaEstudiante()),
                        "Modificar registro", JOptionPane.INFORMATION_MESSAGE);
                limpiarPanelDatos();
            }
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Eliminar"))
        {
            String carne = this.jPanelDatosEstudiante.jTextFieldCarne.getText();
            Estudiante estudiante = this.almacenEstudiante.buscarEstudiante(carne);
            if(estudiante != null)
            {
                int opcion = JOptionPane.showConfirmDialog(
                        this.jFrameEstudiante,
                        "Está de acuerdo en eliminar el registro con el carné("
                                + estudiante.getCarne()+ ") de nombre ("
                                + estudiante.getNombre() + ")?",
                        "Eliminar registro", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE);
                
                if(opcion == 0)//aqui se pone la condicion asi porque yes = 0 y no = 1
                {
                     JOptionPane.showMessageDialog(this.jFrameEstudiante,
                             this.almacenEstudiante.eliminarEstudiante(estudiante));
                     limpiarPanelDatos();
                }
                
            }
           
                
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Listar"))
        {
            JFrameReporteEstudiante jFrameReporteEstudiante = new JFrameReporteEstudiante();
            DefaultTableModel tablaModelo = new DefaultTableModel();
            JTable tablaDatos = jFrameReporteEstudiante.jPanelTablaDatosEstudiante.jTable2;
            
            tablaDatos.setModel(this.almacenEstudiante.getListaEstudiante(tablaModelo));
            
            jFrameReporteEstudiante.setVisible(true);
        }
        
    }

    public boolean esValidoDatos() {
        if (jPanelDatosEstudiante.jTextFieldCarne.getText().isEmpty()) {
            return false;
        } else if (jPanelDatosEstudiante.jTextFieldNombre.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void limpiarPanelDatos() {
        this.jPanelDatosEstudiante.jTextFieldCarne.setText("");
        this.jPanelDatosEstudiante.jTextFieldNombre.setText("");
    }

    private Estudiante crearInstanciaEstudiante() {
        Estudiante estudiante = new Estudiante(
                this.jPanelDatosEstudiante.jTextFieldCarne.getText(),
                this.jPanelDatosEstudiante.jTextFieldNombre.getText());
        return estudiante;
    }

}
