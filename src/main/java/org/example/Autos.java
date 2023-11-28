package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;

@Setter
@Getter
public class Autos extends Thread {

    private ArrayList<Auto> autos;
    private Double mayorDistancia;
    public Autos() {
        mayorDistancia = 0.0;
        autos = new ArrayList<>();
    }

    public void run() {
        while(true) {
            try {

                actualizarRecorrido();
                sleep(1000);

                if (obtenerAutosActuales() == 0) {
                    this.mayorDistancia = 0.0;
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void crearAuto(Auto auto) {
        this.autos.add(auto);
    }

    public void actualizarRecorrido() {
        for (int i = 0; i < this.autos.size(); i++) {
            if (this.autos.get(i).TiempoCumplido()) {
                this.autos.remove(i);
                i--; //Volvemos a preguntar por el nuevo auto que se ubica en la posición

                if (i >= this.autos.size()) break;
            }
            else {
                this.autos.get(i).actualizarDistancia();
            }

            //En caso que el tamaño actualmente sea menor que i
            if (this.autos.size() < i) break;
        }

        try {
            Chart.createDistanceChart(this.autos, mayorDistancia);
            Chart.getCarActualDistance(this.autos, mayorDistancia);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public Integer obtenerAutosActuales() {
        return this.autos.size();
    }

}
