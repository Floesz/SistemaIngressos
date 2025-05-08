/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 * @author Guilherme
 */
public class Inteira extends Ingresso {

    private double precoInicial;

    public Inteira() {
    }

    public Inteira(String evento, String data, double precoInicial) {
        super(evento, data);
        this.precoInicial = precoInicial;
    }

    @Override
    public double calcularValor() {
        return precoInicial;
    }


    @Override
    public String imprimirIngresso() {
        return "Ingresso Normal\n Evento:" + evento + "\n Data:" + data + "\n Valor:" + calcularValor();
    }


}
