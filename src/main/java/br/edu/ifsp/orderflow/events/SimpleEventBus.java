package br.edu.ifsp.orderflow.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleEventBus implements IEventBus {
    private final Map<Class<? extends IDomainEvent>, List<IEventHandler<?>>> handlers = new HashMap<>();

    @Override
    public <E extends IDomainEvent> void register(IEventHandler<E> handler) {
        handlers.computeIfAbsent(handler.eventType(), eventType -> new ArrayList<>()).add(handler);
    }

    @Override
    public <E extends IDomainEvent> void publish(E event) {
        for (IEventHandler<?> handler : handlers.getOrDefault(event.getClass(), List.of())) {
            dispatch(handler, event);
        }
    }

    private <E extends IDomainEvent> void dispatch(IEventHandler<E> handler, IDomainEvent event) {
        handler.handle(handler.eventType().cast(event));
    }
}
