package br.edu.ifsp.orderflow;

import br.edu.ifsp.orderflow.domain.Cliente;
import br.edu.ifsp.orderflow.domain.ItemPedido;
import br.edu.ifsp.orderflow.domain.Pedido;
import br.edu.ifsp.orderflow.domain.Produto;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Produto mouse = new Produto(
                "SKU-1",
                "Mouse sem fio",
                new BigDecimal("120.00")
        );

        Produto teclado = new Produto(
                "SKU-2",
                "Teclado sem fio",
                new BigDecimal("350.00")
        );

        Produto monitor = new Produto(
                "SKU-3",
                "Monitor 4K",
                new BigDecimal("1800.00")
        );

        Cliente ana = new Cliente("Ana", "ana@gmail.com");
        Cliente bruno = new Cliente("Bruno", "bruno@gmail.com");

        Pedido pedido1 = new Pedido(ana);
        pedido1.AdicionarItem(new ItemPedido(mouse, 2));
        pedido1.AdicionarItem(new ItemPedido(teclado, 1));

        Pedido pedido2 = new Pedido(bruno);
        pedido2.AdicionarItem(new ItemPedido(monitor, 2));
        pedido2.AdicionarItem(new ItemPedido(teclado, 5));

        System.out.println(pedido1);
        System.out.println(pedido2);
    }
}
