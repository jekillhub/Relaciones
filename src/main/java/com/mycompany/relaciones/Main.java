package com.mycompany.relaciones;

public class Main {
    
    public static void main(String[] args) {
        Matriz m = new Matriz();
        m.ingresoConjuntos(m.conjuntoA);
        m.ingresoConjuntos(m.conjuntoB);
        m.comprobacionLargo();
        m.sizeRelacion();
        m.generarRelacion();
        m.comprobarReflexion();
        m.comprobarSimetria();
        m.comprobarTransitividad();
        m.mostarInfo();
    }
    
}
