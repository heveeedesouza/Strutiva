package com.strutiva.repositorio;
import com.strutiva.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepositorio extends JpaRepository<Produto, Long>    {
    
}
