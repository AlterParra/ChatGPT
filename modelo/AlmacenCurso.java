/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Soporte
 */
public class AlmacenCurso {
    
        private static AlmacenCurso instanciaCurso = null; 
        private ArrayList<Curso> arregloCurso;
        private String mensaje;

    public AlmacenCurso() {
    }
                
 
    public static AlmacenCurso getInstanciaCurso()
    {
        if (instanciaCurso == null)
              instanciaCurso = new AlmacenCurso();
        
        return instanciaCurso; 
          
    }
    
    public String nuevoCurso(Curso curso)
    {
        if(noExiste(curso)==true)
        {
            this.arregloCurso.add(curso);
            return "Curso agregado exitosamente";
        }
        
        return "Ya existe un curso con la misma sigla";
    }
    
    public boolean noExiste(Curso curso)
    {
        for(Curso c : this.arregloCurso){
            if(c.getSigla().equalsIgnoreCase(curso.getSigla())){
                return false;
            }
        }
            return true;
    }
    
    public Curso buscarCurso(String sigla)
    {
        for(Curso c : this.arregloCurso){
            if(c.getSigla().equalsIgnoreCase(sigla)){
                return c; 
            }
        }
            
        return null;
    }
   
    public String modificarCurso(Curso curso)//le entra un curso por parametro, si el curso existe
    {
        if(noExiste(curso) != true)
        {
           for(Curso c : this.arregloCurso)
               if(c.getSigla().equalsIgnoreCase(curso.getSigla()))
               {
                   c.setSigla(curso.getSigla());
                   c.setNombre(curso.getNombre());
                   c.setCreditos(curso.getCreditos());
                   
                   return "Curso modificado exitosamente";
               }
        
        }
            
             return "No existe un curso con esa sigla";
            
    }
    
    public String eliminarCurso(Curso curso)
    {
        if(noExiste(curso) == false)
        {
            this.arregloCurso.remove(curso);
            return "Curso eliminado";
            
        }
            return "Curso no encontrado"; 
    }
    
    public String getArregloCurso()
    {
        mensaje = " ";
        
        for(Curso c : this.arregloCurso)
            mensaje += c.toString()+"\n";
        
        return mensaje;
    }
    
    public TableModel getListaCurso(DefaultTableModel tablaModelo)
    {      
        tablaModelo.addColumn("Sigla");
        tablaModelo.addColumn("Nombre");
        tablaModelo.addColumn("Créditos");
        
        Object[]fila;
        for(Curso c: this.arregloCurso)
        {
            fila = new Object[3];
            fila[0] = c.getSigla();
            fila[1] = c.getNombre();
            fila[2] = c.getCreditos();
            tablaModelo.addRow(fila);
        }
        
        return tablaModelo; 
    }
    
    public void setArregloCurso()
    {

    }
    
}//fin de la clase AlmacenCurso
