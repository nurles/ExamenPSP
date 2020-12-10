package es.centroafuera.psp.concurrencia;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BattleRoyale batalla = new BattleRoyale();
        final int totalJugadores = 15;

        ArrayList <Jugador> list = new ArrayList<>();

        for(int i=0;i<totalJugadores;i++){
            Jugador jugador = new Jugador(batalla);
            jugador.setName("Jugador "+i);
            jugador.start();
            list.add(jugador);
        }
    }
}
