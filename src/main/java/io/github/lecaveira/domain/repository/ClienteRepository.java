package io.github.lecaveira.domain.repository;

import io.github.lecaveira.domain.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClienteRepository {

    private static String INSERT = "insert into cliente (nome) value (?)";
    private static String SELECT_ALL = "select * from CLIENTE";
    private static String UPDATE = "update cliente set nome  = ? where id = ?";
    private static String DELETE = "delete from cliente where id = ?";

    @Autowired
    private JdbcTemplate jdcTemplate;

    public ClienteEntity salvar(ClienteEntity cliente){

        jdcTemplate.update(INSERT, new Object[]{cliente.getNome()} );
        return cliente;

    }

    public ClienteEntity atualizar(ClienteEntity cliente){
        jdcTemplate.update(UPDATE, new Object[]{cliente.getNome(), cliente.getId()});

        return cliente;
    }

    public void deletar(ClienteEntity cliente){
        deletar(cliente.getId());
    }

    public void deletar(Integer id){
        jdcTemplate.update(DELETE, new Object[]{id});
    }
    
    public List<ClienteEntity> buscarNome(String nome){
        return jdcTemplate.query(SELECT_ALL.concat("where nome like ?"), new Object[]{"%" + nome + "%"}, obterClienteRowMapper());
    }

    public List<ClienteEntity> obterTodos(){
        return jdcTemplate.query(SELECT_ALL, obterClienteRowMapper());
    }

    private static RowMapper<ClienteEntity> obterClienteRowMapper() {
        return new RowMapper<ClienteEntity>() {
            @Override
            public ClienteEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                return new ClienteEntity(id, nome);
            }
        };
    }

}
