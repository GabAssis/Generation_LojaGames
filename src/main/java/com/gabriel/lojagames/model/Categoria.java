package com.gabriel.lojagames.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O atributo nome é Obrigatório!")
    @Size(min = 4,max = 70,message = "O atributo nome deve conter no mínimo 04 e no máximo 100 caracteres")
    private String nomeCategoria;

    @NotBlank
    private String descricao;

    @NotBlank
    @Column(unique = true)
    private String iconeCategoria;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "categoria",cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("categoria")
    private List<Produtos> produtos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.produtos = produtos;
    }

    public String getIconeCategoria() {
        return iconeCategoria;
    }

    public void setIconeCategoria(String iconeCategoria) {
        this.iconeCategoria = iconeCategoria;
    }

}
