package io.github.athirson010.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    //muitos itensPedidos para um pedido
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    //muitos itensPedido para um produto
    private Produto produto;
    @Column
    private Integer quantidade;

}
