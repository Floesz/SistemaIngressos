/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 * @author Guilherme
 */
public class Meia_Entrada extends Ingresso {

    private double precoInicial;

    public Meia_Entrada() {
    }

    public Meia_Entrada(String evento, String data, double precoInicial) {
        super(evento, data);
        this.precoInicial = precoInicial;
    }

    @Override
    public double calcularValor() {
        return precoInicial / 2;
    }

    @Override
    public String imprimirIngresso() {
        return "Ingresso Meia Entrada\n Evento:" + evento + "\n Data:" + data + "\n Valor:" + calcularValor();
    }

}
