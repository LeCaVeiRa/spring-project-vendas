package io.github.lecaveira.domain.repository;

import io.github.lecaveira.domain.entity.ItemPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, Integer> {
}
