package io.github.athirson010.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;

    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
}
