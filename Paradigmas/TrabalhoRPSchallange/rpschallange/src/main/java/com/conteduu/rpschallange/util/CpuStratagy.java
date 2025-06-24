package com.conteduu.rpschallange.util;

/*

    "IA adaptativa"
    - Manter as N (window) ultimas jogadas do HUMANO
    - Contar qual jogada aparece mais nesse intervalo
    - Devolver a jogada que vence essa mais frequente
*/

import com.conteduu.rpschallange.model.Move;

import java.util.ArrayDeque;

public class CpuStratagy {
    /*
        Historico "circular" das jogadas do player
        Usar ArrayDeque -> addLast / removeFirst

        Variavel int com o tamnho da "janela"

        Construtor que inicializa a janela de jogadas

        Metodo que vai ser responsavel por calcular qual a
        jogada a CPU deve fazer agora

    * */

    private static final int MAX_QUEU_HISTORIC = 3;

    public Move proximaJogada(Move jogadaAtual){
        /*
            Atualizar a Deque com a jogada mais recente
            Se passou o limite da janela, descartar o elemento
            mais antigo(removeFirst)

            Tratar se ainda é a primeira jogada

            Contar quantas vezes cada jogada aparece na janela
            Ex: se o mais frequente for PAPEL então retorna TESOURA

         */

        ArrayDeque<Move> historic = new ArrayDeque<>();

        if (historic.size() < MAX_QUEU_HISTORIC) {
            Move jogadaCPU = Move.random();
            historic.add(jogadaCPU);
            return jogadaCPU;
        }

        // Verificar quais as ultimas jogadas mais utilizadas

        return null;
    }
}
