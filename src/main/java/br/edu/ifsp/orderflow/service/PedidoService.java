package br.edu.ifsp.orderflow.service;

import br.edu.ifsp.orderflow.domain.Pedido;

public class PedidoService {

    private IEstoqueService estoqueService;

    public PedidoService(IEstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    public Pedido processar(Pedido pedido) {
        boolean foiReservado = this.estoqueService.reservar(pedido);

        if (!foiReservado) {
            pedido.cancelar();
            // todo: salvar o pedido
            return pedido;
        }

        // todo: Processar o pagamento

        // todo: salvar se pagamento ocorreu com sucesso

        // todo: notificar o cliente

        // retona o pedido
        return pedido;
    }
}
