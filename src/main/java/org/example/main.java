package org.example;

import java.awt.*;

public class main {

    public static void main(String[] args) {
        Autos autos = new Autos(null);
        autos.start();
        autos.crearAuto(new Auto(Color.BLUE, 20.0, 100.0));
        autos.crearAuto(new Auto(Color.RED, 40.0, 200.0));
    }
}
