package com.conteduu.model;

// Representa um dado fixo (Jogador) com seus atributos
public record Player(
        String id,
        String nome,
        int pontos,
        int vitorias
) {}
