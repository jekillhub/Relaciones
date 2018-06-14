package com.mycompany.relaciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Matriz {

    public ArrayList<Integer> conjuntoA;
    public ArrayList<Integer> conjuntoB;
    public int[][] relacion;
    public boolean reflexividad;
    public boolean simetria;
    public boolean transitividad;

    public Matriz() {

        this.conjuntoA = new ArrayList<>();
        this.conjuntoB = new ArrayList<>();
        this.reflexividad = false;
        this.simetria = false;
        this.transitividad = false;

    }

    //METODOS DE INGRESO Y VALIDACION DE CONJUNTOS
    public void ingresoConjuntos(ArrayList conjunto) {

        Scanner sc = new Scanner(System.in);
        int num = 0;
        
        System.out.println("Ingrese numeros: ");
        num = sc.nextInt();
        comprobacionNumExists(conjunto, num);
        
        conjunto.add(num);

        this.repetirIngreso(conjunto);

    }

    public void repetirIngreso(ArrayList conjunto) {

        Scanner sc = new Scanner(System.in);
        int opc = 0;

        do {

            System.out.println("Desea agregar otro numero? ");
            System.out.println("1. SI");
            System.out.println("2. NO");
            opc = sc.nextInt();

        } while (opc < 1 || opc > 2);

        if (opc == 1) {

            this.ingresoConjuntos(conjunto);

        }

    }

    public void comprobacionLargo() {

        if (this.conjuntoA.size() != this.conjuntoB.size()) {

            System.out.println("El largo de los conjuntos son distintos");
            
            this.conjuntoA.clear();
            this.conjuntoB.clear();
            
            System.out.println("Matriz A");
            this.ingresoConjuntos(this.conjuntoA);
            System.out.println("Matriz B");
            this.ingresoConjuntos(this.conjuntoB);

        }

    }

    public void comprobacionNumExists(ArrayList conjunto, int num) {

        if (conjunto.contains(num) == true) {

            System.out.println("El conjunto ya posee el numero ingresado");
            this.ingresoConjuntos(conjunto);

        }

    }

    public void comprobacionNumRango(ArrayList conjunto, int num) {

        if (num < 1) {

            System.out.println("El numero ingresado no es valido");
            this.ingresoConjuntos(conjunto);

        }

    }

    //METODOS RELACION
    public void sizeRelacion() {

        this.relacion = new int[this.conjuntoA.size()][this.conjuntoA.size()];

    }

    public void sizeRelacion(int dim) {

        this.relacion = new int[dim][dim];

    }

    public void generarRelacion() {

        for (int i = 0; i < this.conjuntoA.size(); i++) {

            for (int j = 0; j < this.conjuntoB.size(); j++) {

                this.relacion[this.conjuntoA.get(i)][this.conjuntoB.get(j)] = 1;

            }

        }

    }

    //METODOS COMPROBACION REFLEXION, TRANSITIVIDAD Y SIMETRIA.
    public void comprobarReflexion() {

        int contador = 0;

        for (int i = 0; i < this.relacion.length; i++) {

            for (int j = 0; j < this.relacion.length; j++) {

                if (this.relacion[i][i] == 1) {

                    contador = contador + 1;

                }

            }

        }

        if (contador == this.relacion.length) {

            this.reflexividad = true;

        }

    }

    public int[][] trasponer() {

        int[][] traspuesta = new int[this.conjuntoA.size()][this.conjuntoA.size()];

        for (int i = 0; i < traspuesta.length; i++) {

            for (int j = 0; j < traspuesta.length; j++) {

                traspuesta[i][j] = this.relacion[j][i];

            }
        }

        return traspuesta;

    }

    public void comprobarSimetria() {
        
        if (Arrays.deepEquals(this.relacion, trasponer())) {
        
            this.simetria = true;
        
        }
    
    }
    
    public void comprobarTransitividad(){
    
    
    
    }
    
    public int[][] cuadrardoMatriz(){
    
       int[][] cuadrado = new int[this.conjuntoA.size()][this.conjuntoA.size()];

        for (int i = 0; i < cuadrado.length; i++) {

            for (int j = 0; j < cuadrado.length; j++) {

                cuadrado[i][j] = this.relacion[j][i];

            }
        }

        return cuadrado; 
    
    }
    
    
    public void mostarInfo(){
    
        System.out.println("Reflexividad: "+ this.reflexividad);
        System.out.println("Simetría: "+ this.simetria);
        System.out.println("Transitividad: + this.transitividad");
        
    
    }

    
}
