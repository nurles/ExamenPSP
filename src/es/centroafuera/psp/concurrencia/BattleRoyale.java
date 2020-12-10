package es.centroafuera.psp.concurrencia;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BattleRoyale {
    private static int plazasEnPrimeraRonda = 10;
    private static int campeonesPrimeraRonda = 5;
    private static boolean hayPrimero = false;
    private final int cantMax = 10;
    private final Semaphore semaphore = new Semaphore(cantMax, false);

    public void añadirParticipante(Jugador jugador){
        try {
            semaphore.acquire();
            System.out.println("El "+jugador.getName()+" ha entrado en la batalla");

            calcularPrimeraRonda(jugador);

            Random r = new Random();
            int sleepingTime = r.nextInt(4000) + 1000;
            System.out.println("El "+jugador.getName()+" dormirá por "+sleepingTime);

            Thread.sleep(sleepingTime);

            calcularPrimeroEnLlegar(jugador);
            calcularSiEsDeLos5Primeros(jugador);

            calcularPutuacion(jugador);

            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private static synchronized void calcularSiEsDeLos5Primeros(Jugador jugador) {
        if(campeonesPrimeraRonda > 0){
            campeonesPrimeraRonda--;
            jugador.setEsCampeonPrimeraRonda(true);
        }
    }

    private static void calcularPutuacion(Jugador jugador) {
        Random r = new Random();
        int puntuacion = r.nextInt(1000);

        if(jugador.isPrimeraTanda()){
            if(jugador.isEsCampeonPrimeraRonda()) {
                if (jugador.isEsPrimero()) {
                    puntuacion *= 2;
                }
                jugador.setPuntuacion(puntuacion);
            }
        }else{
            jugador.setPuntuacion(puntuacion);
        }
    }

    //Cuando se llame a esta funcion solo puede ejecutarse uno a la vez al ser synchronized
    private static synchronized void calcularPrimeroEnLlegar(Jugador jugador){
        if(!hayPrimero){
            //Es el primer jugador en entrar y por tanto guardamos su tiempo como el mas rapido
            jugador.setEsPrimero(true);
            System.out.println("El "+jugador.getName()+" ha sido el primero en llegar y lleva el bonus");
            hayPrimero = true;
        }
    }

    private static synchronized void calcularPrimeraRonda (Jugador jugador){
        if(plazasEnPrimeraRonda > 0){
            plazasEnPrimeraRonda--;
            jugador.setPrimeraTanda(true);
        }
    }


}
