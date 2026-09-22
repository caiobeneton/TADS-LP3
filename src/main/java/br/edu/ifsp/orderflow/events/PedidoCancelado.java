package br.edu.ifsp.orderflow.events;

import java.time.Instant;

public record PedidoCancelado (String pedidoId, Instant ocorridoEm, String motivo) implements IDomainEvent{


}
