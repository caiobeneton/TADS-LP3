package br.edu.ifsp.orderflow.events;

public interface IEventBus {
    <E extends IDomainEvent> void register(IEventHandler<E> handler);

    <E extends IDomainEvent> void publish(E event);
}
