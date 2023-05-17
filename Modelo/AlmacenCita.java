/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Soporte
 */
public class AlmacenCita {
    
    private static AlmacenCita instancia = null;
    private ArrayList<Cita> arregloCita = new ArrayList<>(); //el arreglo que guarda las citas
    private String mensaje;

    public AlmacenCita() {
        
    } 
            
    public static AlmacenCita getInstancia()//Esto es para solo tener una instancia de la clase AlmacenCita en todo el programa 
    {
        if(instancia == null)
            instancia = new AlmacenCita();
        
        return instancia; 
        
    }
    
    public String agregarCita(Cita cita)//Este lo voy a dejar de ultimo porque aqui tengo que verificar que las citas esten disponibles cada 30 min
    {                                   //que un medico no tenga mas de una cita al mismo tiempo
         if(noExiste(cita) == true)                               //y que un paciente no tenga mas de una cita al mismo tiempo
         {
             this.arregloCita.add(cita);
                return "Cita agregada exitosamente"; 
         }                      
        return "Esta cita no pudo ser agregada debido a que ya existe";
    }
    
    public Cita buscarCita(String paciente)
    {
        for(Cita c : this.arregloCita){
            if(c.getPaciente().equalsIgnoreCase(paciente));
                    return c;
        }
        return null;        
        
    }
    
    public boolean noExiste(Cita cita)
    {
       for(Cita c : this.arregloCita)
            if(c.getPaciente().equalsIgnoreCase(cita.getPaciente()))
                return false;
        
       return true;
       
    }
    
    public String ModificarCita(Cita cita)
    {
        if(noExiste(cita) != true)
        {
            for(Cita c : this.arregloCita)
            if(c.getPaciente().equalsIgnoreCase(cita.getPaciente()))
            {
                c.setFecha(cita.getFecha());
                c.setHora(cita.getHora());
                c.setEspecialidad(cita.getEspecialidad());
                c.setMedico(cita.getMedico());
                c.setPaciente(cita.getPaciente());
                
                return "Cita modificada exitosamente";
                
            }
            
        }
        
        return "No existe una cita registrada con el nombre de este paciente";
    }
        
    public String eliminarCita(Cita cita)
    {
        if(noExiste(cita) != true)
        {
            this.arregloCita.remove(cita);
                 return "Cita eliminada exitosamente";
                
        }
            
        return "Esta cita no existe ";
            
    }
        
    
        
    
}
