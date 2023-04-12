/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Soporte
 */
public class Curso {
    
    private String sigla;
    private String nombre;
    private int creditos; 

    public Curso() {
        sigla = "";
        nombre = "";
        creditos = 0;
    }

    public Curso(String sigla, String nombre, int creditos) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    
    
}
