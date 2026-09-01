package br.edu.ifsp.orderflow.service;

import br.edu.ifsp.orderflow.domain.Pedido;
import br.edu.ifsp.orderflow.domain.ResultadoPagamento;

public class PedidoService {

    private IEstoqueService estoqueService;
    private IPedidoRepository pedidoRepository;
    private IPagamentoGateway pagamentoGateway;
    private INotificacaoService notificacaoService;

    public PedidoService(
            IEstoqueService estoqueService,
            IPedidoRepository pedidoRepository,
            IPagamentoGateway pagamentoGateway,
            INotificacaoService notificacaoService
    ) {
        this.estoqueService = estoqueService;
        this.pedidoRepository = pedidoRepository;
        this.pagamentoGateway = pagamentoGateway;
        this.notificacaoService = notificacaoService;
    }

    public Pedido processar(Pedido pedido) {
        boolean foiReservado = this.estoqueService.reservar(pedido);

        if (!foiReservado) {
            pedido.cancelar();
            this.pedidoRepository.save(pedido);
            return pedido;
        }

        ResultadoPagamento resultado = this.pagamentoGateway.pagar(pedido);
        if (!resultado.isAprovado()){
            this.estoqueService.liberar(pedido);
            pedido.cancelar();
            this.pedidoRepository.save(pedido);
            return pedido;
        }

        pedido.marcarComoPago();
        this.pedidoRepository.save(pedido);

        this.notificacaoService.notificar(
                pedido.getCliente(),
                "Pagamento aprovado!" + pedido.getIdCurto() + " confirmado"
        );

        return pedido;
    }
}
