package com.coletas.coletas.util;

public enum DeliveryStatus {
    APROVADO("Aprovado"),
    PENDENTE("Pendente"),
    REJEITADO("Rejeitado");

    private final String descricao;

    DeliveryStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}