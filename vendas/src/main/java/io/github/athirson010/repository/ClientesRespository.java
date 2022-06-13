package io.github.athirson010.repository;

import io.github.athirson010.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//herda de componente
//Essa anotação faz com que no container do spring inicializa essa instancia.
public interface ClientesRespository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeLike(String nome);
    List<Cliente> findByNomeOrIdOrderById(String nome, Long id);
    Cliente findOneByNome(String nome);
    boolean existsByNome(Object nome);

    @Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> encontrarPorNome( @Param("nome") String nome );

    @Query(" delete from Cliente c where c.nome =:nome ")
    @Modifying
    void deleteByNome(String nome);
    @Query("select c from Cliente c left join fetch c.pedidos p where c.id = :id")
        //buscando um cliente mesmo se não houver pedidos
    Cliente findClienteFetchPedidos(@Param("id") Long id);

}
