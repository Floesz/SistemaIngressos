/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 * @author Guilherme
 */
public abstract class Ingresso {

    protected String evento;
    protected String data;

    public Ingresso(String evento, String data) {
        this.evento = evento;
        this.data = data;
    }

    public Ingresso() {

    }

    public abstract double calcularValor();

    public abstract String imprimirIngresso();

}
