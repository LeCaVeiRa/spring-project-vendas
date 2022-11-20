package io.github.lecaveira.domain.repository;

import io.github.lecaveira.domain.entity.ClienteEntity;
import io.github.lecaveira.domain.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {

    List<PedidoEntity> findByCliente(ClienteEntity cliente);

}
