
package modelo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author mag
 */
public class AlmacenEstudiante {
    
    //se crean los atributos
    private static AlmacenEstudiante instancia = null;
    private ArrayList<Estudiante> arregloEstudiante;
    private String mensaje;

    
    //Constructor privado para prevenir la creacioón de nuevas instancias
    //Utilizaremos un patron de diseño singleton que garantiza que solo haya una instancia de AlmacenEstudiante en toda la app
    public AlmacenEstudiante() {
        this.arregloEstudiante = new ArrayList<>();
    }

    
    //hago un metodo estatico para obtener la unica instancia de almacenEstudiante para poder usar singleton creo
    public static AlmacenEstudiante getInstancia() {
        if(instancia == null){
            instancia = new AlmacenEstudiante();
        }
        return instancia;
    }
    
    

    public String crearEstudiante(Estudiante estudiante) {
        this.arregloEstudiante.add(estudiante);
        return "El estudiante fue creado satisfactoriamente";
    }
    
    public Estudiante buscarEstudiante(String carne) {
        for(Estudiante e : this.arregloEstudiante){
            if(e.getCarne().equalsIgnoreCase(carne)){
                return e;
            }
        }
        return null;
    }

    public String modificarEstudiante(Estudiante estudiante) {
        for(Estudiante e : this.arregloEstudiante){
            if(e.getCarne().equalsIgnoreCase(estudiante.getCarne())){
                e.setNombre(estudiante.getNombre());
                return"Se ha actualizado el registro con el carne ("+e.getCarne() +")";
            }
        }
        return "No existe el registro con el numero de carné(" + estudiante.getCarne()+")";
    }

    public String eliminarEstudiante(Estudiante estudiante) {
//        for(Estudiante e : this.arregloEstudiante)
//        {
//            if(e.getCarne().equalsIgnoreCase(estudiante.getCarne())){
               this.arregloEstudiante.remove(estudiante);
                return "Registro eliminado"; 
//            }
//        }
        
//        return "El registro no pudo ser eliminado";      
    }

    public TableModel getListaEstudiante(DefaultTableModel tablaModelo) {
        
        tablaModelo.addColumn("Carné");
        tablaModelo.addColumn("Nombre completo");
        
        Object[] fila;
        for(Estudiante e : this.arregloEstudiante)
        {
            fila = new Object[2];
            fila[0] = e.getCarne();
            fila[1] = e.getNombre();
            tablaModelo.addRow(fila);
        }
        return tablaModelo; 
        
    }
        
    
}
    


