package br.edu.ifsp.orderflow.events.handlers;

import br.edu.ifsp.orderflow.events.IEventHandler;
import br.edu.ifsp.orderflow.events.PedidoCriado;

public class PedidoCriadoLogHandler implements IEventHandler<PedidoCriado> {


    @Override
    public void handle(PedidoCriado event) {
        System.out.println(
                "[Log]"
        );
    }

    @Override
    public Class<PedidoCriado> eventType() {
        return PedidoCriado.class;
    }
}
