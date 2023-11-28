package org.example;

import lombok.*;

import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Auto {
    private Color color; //Color del punto o auto
    private Double velocidad; //Velocidad en metros por segundo.
    private Double distancia; //Distancia en metros.
    private Integer tiempoActual; //Tiempo para ver si se elimina el vehículo o no
    private Integer tiempoTotal; //Tiempo total del recorrido.
    private ArrayList<Double> distancias; //Se guardan las distancias por segundo.

    public Auto(Color color, Double velocidad, Double distancia) {
        this.color = color;
        this.velocidad = velocidad;
        this.distancia = distancia;
        this.tiempoActual = 0;
        this.tiempoTotal = (int) (this.distancia/this.velocidad);
        System.out.println(tiempoTotal);
        this.distancias = new ArrayList<>();
    }


    //Devuelve un valor booleano si el tiempo actual sobrepasa al total.
    public boolean TiempoCumplido() { return (this.tiempoTotal < this.tiempoActual); }

    public void actualizarDistancia() {
        if (this.tiempoActual > 0) {
            this.distancias.add(this.velocidad * this.tiempoActual);
        }
        else {
            this.distancias.add(0.0);
        }
        this.tiempoActual++;
    }

    public double[] toDouble() {
        double[] respuesta = new double[this.distancias.size()];
        int counter = 0;
        for (double distancia: this.distancias) {
            respuesta[counter] = distancia;
            System.out.println(respuesta[counter]);
            counter++;
        }
        return respuesta;
    }
}
