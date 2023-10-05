package com.gabriel.lojagames.repository;

import com.gabriel.lojagames.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutosRepository extends JpaRepository<Produtos,Long> {

    public List<Produtos> findAllByPrecoAfter(@Param("preco")BigDecimal preco);

}
