package io.github.athirson010.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "tb_cliente", aqui estou personalizando o nome da minha entidade do banco
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NOME", length = 100)
    private String nome;

    //Um cliente tem muitos pedidos
    //@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER) por padrão é utilizado eager para não trazer
    //os pedidos deste usuario, para não ter lentidão
    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Pedido> pedidos = new ArrayList<>();
}
