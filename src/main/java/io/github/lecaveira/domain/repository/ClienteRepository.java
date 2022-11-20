package io.github.lecaveira.domain.repository;

import io.github.lecaveira.domain.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

    List<ClienteEntity> findByNome(String nome);

    boolean existsByNome(String nome);

    @Query("delete from Cliente c where c.nome =:nome")
    @Modifying
    void deleteByNome(String nome);

    @Query("select c from Cliente c left join fetch c.pedidos where c.id =:id ")
    ClienteEntity findClienteFetchPedidos(@Param("id") Integer id);

}
