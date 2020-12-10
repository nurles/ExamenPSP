package es.centroafuera.psp.concurrencia;

public class Jugador extends Thread{
    BattleRoyale batalla;
    private boolean esPrimero = false;
    private boolean primeraTanda = false;
    private boolean esCampeonPrimeraRonda = false;
    private int puntuacion = 0;

    public Jugador(BattleRoyale batalla){
        this.batalla=batalla;
    }

    @Override
    public void run() {
        System.out.println("El "+getName()+ " esta listo para entrar");
        batalla.añadirParticipante(this);

    }
     public void setEsPrimero(boolean esPrimero){
        this.esPrimero = esPrimero;
     }

     public boolean isEsPrimero(){
        return esPrimero;
     }

    public void setPrimeraTanda(boolean primeraTanda) {
        this.primeraTanda = primeraTanda;
    }

    public boolean isPrimeraTanda (){
        return primeraTanda;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public boolean isEsCampeonPrimeraRonda() {
        return esCampeonPrimeraRonda;
    }

    public void setEsCampeonPrimeraRonda(boolean esCampeonPrimeraRonda) {
        this.esCampeonPrimeraRonda = esCampeonPrimeraRonda;
    }
}
