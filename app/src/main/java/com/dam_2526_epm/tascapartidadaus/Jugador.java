package com.dam_2526_epm.tascapartidadaus;

public class Jugador extends Persona{

    private int idJugador;

    private int casella;

    public Jugador(String nom, String cognom, int edat, int idJugador, int casella) {
        super(nom, cognom, edat);
        this.idJugador = idJugador;
        this.casella = casella;
    }

    public int getNumJugador() {
        return idJugador;
    }

    public void setNumJugador(int idJugador) {
        this.idJugador = idJugador;
    }



    public int getRecorregut() {
        return casella;
    }

    public void setRecorregut(int casella) {
        this.casella = casella;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "Numero de Jugador=" + idJugador + " "
                + super.toString() + "}";
    }
}
