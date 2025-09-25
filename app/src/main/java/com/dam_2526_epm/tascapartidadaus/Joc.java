package com.dam_2526_epm.tascapartidadaus;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Joc implements Resultat{
    private ArrayList<Jugador> jugadors;

    public ArrayList<Jugador> getJugadors() {
        return jugadors;
    }

    public void setJugadors(ArrayList<Jugador> jugadors) {
        this.jugadors = jugadors;
    }

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    String resultatFinal = null;

    public void iniciarPartida(){
        boolean acabat = false;
        while(!acabat){
            for (Jugador jugador : jugadors){
                System.out.println("Torn de " + jugador.getNom() + " (Prem Enter)");
                scanner.nextLine();

                String resultatTirada = Tirardaus(jugador);
                System.out.println(resultatTirada);

                if (jugador.getRecorregut() == 63){
                    acabat = true;
                    resultatFinal = guanyador(jugador);
                    break;
                }
            }
        }
        System.out.println(resultatFinal);
    }
    public String Tirardaus(Jugador jugador) {
        int dau = random.nextInt(6) + 1;

        String resultatEspecial;
        //Caselles especials

        switch (jugador.getRecorregut() + dau) {
            case 5:
                jugador.setRecorregut(9);
                System.out.println("El jugador ha caigut a la casella " + jugador.getRecorregut()
                                    + " (oca), per tant avança a la casellla 9 i pot tornar a tirar");
                System.out.println(resultatEspecial = Tirardaus(jugador));
                break;
            case 6:
                jugador.setRecorregut(12);
                break;
            default:
                if (jugador.getRecorregut() + dau > 63) {
                    return "El jugador " + jugador.getNumJugador()
                            + " ha tret" + dau
                            +". El jugador no pot estar en una casella mes alta que 63." + '\n';
                } else {
                    jugador.setRecorregut(jugador.getRecorregut() + dau);
                }

                return "El jugador " + jugador.getNumJugador()
                        + " ha tret " + dau;

        }
        return "Casella actual:" + jugador.getRecorregut();
    }

    @Override
    public String guanyador(Jugador jugador) {
        return "El guanyador es: " + jugador;
    }
}
