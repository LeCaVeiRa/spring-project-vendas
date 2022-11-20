package io.github.lecaveira.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoEntity {

    private Integer id;
    private ClienteEntity cliente;
    private LocalDate dataPedido;
    private BigDecimal totla;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getTotla() {
        return totla;
    }

    public void setTotla(BigDecimal totla) {
        this.totla = totla;
    }
}
