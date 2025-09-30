package com.dam_2526_epm.tascapartidadaus;

import java.util.ArrayList;
import java.util.List;
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

        if (jugador.getAtrapat() > 0) {
            jugador.setAtrapat(jugador.getAtrapat() - 1);
            return "El jugador està atrapat i no es pot moure";
        }

        int dau = random.nextInt(6) + 1;
        System.out.println("El jugador " + jugador.getNumJugador() + " ha tret " + dau);

        int novaPos = jugador.getRecorregut() + dau;

        if (novaPos > 63) {
            System.out.println("No pots passar de 63! Et quedes on estaves.");
            return "Casella actual: " + jugador.getRecorregut();
        } else {
            jugador.setRecorregut(novaPos);
        }

        boolean tornaATirar = aplicarCasellaEspecial(jugador);

        if (tornaATirar) {
            return Tirardaus(jugador);
        }

        return "Casella actual: " + jugador.getRecorregut();
    }

    private boolean aplicarCasellaEspecial(Jugador jugador) {
        List<Integer> oques = List.of(5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54, 59);

        int posActual = jugador.getRecorregut();

        if (oques.contains(posActual)) {
            int index = oques.indexOf(posActual);
            if (index + 1 < oques.size()) {
                int novaPos = oques.get(index + 1);
                jugador.setRecorregut(novaPos);
                System.out.println("De oca a oca! El jugador avança a la casella " + novaPos);
                return true;
            }
        }

        switch (posActual) {
            case 6:
                jugador.setRecorregut(12);
                System.out.println("Pont! De 6 a 12");
                return true;
            case 12:
                jugador.setRecorregut(6);
                System.out.println("Pont! De 12 a 6");
                return true;
            case 19:
                jugador.setAtrapat(1);
                System.out.println("Fonda! Perds 1 torn");
                return false;
            case 26:
                jugador.setRecorregut(53);
                System.out.println("Daus! De 26 a 53");
                return true;
            case 31:
                jugador.setAtrapat(2);
                System.out.println("Pou! Perds 2 torns");
                return false;
            case 42:
                jugador.setRecorregut(30);
                System.out.println("Laberint! Tornes enrere");
                return false;
            case 52:
                jugador.setAtrapat(3);
                System.out.println("Presó! Perds 3 torns");
                return false;
            case 53:
                jugador.setRecorregut(26);
                System.out.println("Daus! De 53 a 26");
                return true;
            case 58:
                jugador.setRecorregut(0);
                System.out.println("Mort! Tornes a 0");
                return false;
        }

        return false;
    }

    @Override
    public String guanyador(Jugador jugador) {
        return "El guanyador es: " + jugador;
    }
}
