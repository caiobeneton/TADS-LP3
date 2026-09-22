package br.edu.ifsp.orderflow.events.handlers;

import br.edu.ifsp.orderflow.domain.Pedido;
import br.edu.ifsp.orderflow.events.IEventHandler;
import br.edu.ifsp.orderflow.events.PedidoCancelado;
import br.edu.ifsp.orderflow.service.INotificacaoService;
import br.edu.ifsp.orderflow.service.IPedidoRepository;

import java.util.Optional;

public class PedidoCanceladoNotificacaoHandler implements IEventHandler<PedidoCancelado> {

    private final IPedidoRepository pedidoRepository;
    private final INotificacaoService notificacaoService;

    public PedidoCanceladoNotificacaoHandler(IPedidoRepository pedidoRepository, INotificacaoService notificacaoService) {
        this.pedidoRepository = pedidoRepository;
        this.notificacaoService = notificacaoService;
    }

    @Override
    public void handle(PedidoCancelado event) {
        Optional<Pedido> pedidoEncontrado = this.pedidoRepository.findById(event.pedidoId());
    }

    @Override
    public Class<PedidoCancelado> eventType() {
        return PedidoCancelado.class;
    }
}
