package io.github.lecaveira.domain.repository;

import io.github.lecaveira.domain.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClienteRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public ClienteEntity salvar(ClienteEntity cliente){

        entityManager.persist(cliente);
        return cliente;

    }

    @Transactional
    public ClienteEntity atualizar(ClienteEntity cliente){

        entityManager.merge(cliente);
        return cliente;
    }

    @Transactional
    public void deletar(ClienteEntity cliente){
        if(!entityManager.contains(cliente)){
            cliente = entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
    }

    @Transactional
    public void deletar(Integer id){
        ClienteEntity cliente= entityManager.find(ClienteEntity.class, id);
        deletar(cliente);
    }

    @Transactional(readOnly = true)
    public List<ClienteEntity> buscarNome(String nome){
        String jpql = "select c from Cliente c where c.nome = :nome";
        TypedQuery<ClienteEntity> query = entityManager.createQuery(jpql, ClienteEntity.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    @Transactional
    public List<ClienteEntity> obterTodos(){
        return entityManager.createQuery("from Cliente", ClienteEntity.class).getResultList();
    }

}
