/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Jugador {
    public String nombre;
    public int dinero;
    public int mejor_puntaje;
    public Jugador siguiente;

    public Jugador() {
    }

    public Jugador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Jugador siguiente) {
        this.siguiente = siguiente;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return dinero;
    }

    public int getMejor_puntaje() {
        return mejor_puntaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntaje(int puntaje) {
        this.dinero = puntaje;
    }

    public void setMejor_puntaje(int mejor_puntaje) {
        this.mejor_puntaje = mejor_puntaje;
    }
    
    
    
}
