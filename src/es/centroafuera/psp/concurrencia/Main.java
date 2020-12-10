package es.centroafuera.psp.concurrencia;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        final int totalJugadores = 15;

        ArrayList <Jugador> list = new ArrayList<>();

        for(int i=0;i<totalJugadores;i++){
            Jugador jugador = new Jugador();
            jugador.setName("Jugador "+i);
            jugador.start();
            list.add(jugador);
        }

        for(Jugador j : list){
            try {
                j.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(Jugador j : list){
            System.out.println(j.getName()+" ha sacado un "+j.getPuntuacion());
        }
    }
}
