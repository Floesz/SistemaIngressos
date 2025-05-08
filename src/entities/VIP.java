/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Guilherme
 */
public class VIP extends Ingresso{
    
    private double precoInicial;
    private double precoAdicionalVIP;

    public VIP() {
    }

    public VIP(String evento, String data,double precoInicial, double precoAdicionalVIP) {
        super(evento, data);
        this.precoInicial = precoInicial;
        this.precoAdicionalVIP = precoAdicionalVIP;
    }
    
    @Override
    public double calcularValor(){
        return precoInicial + precoAdicionalVIP;
    }
    
    @Override
    public String imprimirIngresso(){
         return "Ingresso VIP\n Evento:" + evento + "\n Data:" + data + "\n Valor:" + calcularValor();
    }
    
    
}
