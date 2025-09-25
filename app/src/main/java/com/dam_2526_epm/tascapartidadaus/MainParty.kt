package com.dam_2526_epm.tascapartidadaus

import java.util.Scanner

fun main(){

    val partida = Joc()

    val jugadors = ArrayList<Jugador>()

    val scanner = Scanner(System.`in`)

    println("Quants jugadors hi ha?")
    val qttJugadors = scanner.nextInt()


    for (i in 1..qttJugadors){
        scanner.nextLine()
        println("Nom?")
        val nom = scanner.nextLine()

        println("Cognom?")
        val cognom = scanner.nextLine()

        println("Edat?")
        val edat = scanner.nextInt()

        val persona = Persona(nom, cognom, edat)

        val jugador = Jugador(persona.getNom(), persona.getCognom(), persona.getEdat(), i, 0)
        jugador.getNumJugador()

        jugadors.add(jugador)
    }

    partida.jugadors = jugadors
    partida.iniciarPartida()
}