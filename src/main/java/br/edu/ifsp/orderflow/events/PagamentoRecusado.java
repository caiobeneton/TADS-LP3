package br.edu.ifsp.orderflow.events;

import java.time.Instant;

public record PagamentoRecusado(
        String pedidoId,
        String transacaoId,
        Instant ocorridoEm,
        String motivo
) implements IDomainEvent {}
