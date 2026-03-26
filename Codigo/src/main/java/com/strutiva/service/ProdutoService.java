package com.strutiva.service;

import com.strutiva.model.Produto;
import com.strutiva.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    // LISTAR TODOS
    public List<Produto> listarTodos() {
        return produtoRepositorio.findAll();
    }

    // BUSCAR POR ID
    public Produto buscarPorId(Long id) {
        return produtoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // SALVAR
    public Produto salvar(Produto produto) {
        return produtoRepositorio.save(produto);
    }

    // ATUALIZAR
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = buscarPorId(id);

        produto.setNome(produtoAtualizado.getNome());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setPreco(produtoAtualizado.getPreco());

        return produtoRepositorio.save(produto);
    }

    // DELETAR
    public void deletar(Long id) {
        produtoRepositorio.deleteById(id);
    }

    // ESTOQUE BAIXO (R2.5)
    public List<Produto> estoqueBaixo(int limite) {
        return produtoRepositorio.findAll()
                .stream()
                .filter(p -> p.getQuantidade() < limite)
                .toList();
    }
}
