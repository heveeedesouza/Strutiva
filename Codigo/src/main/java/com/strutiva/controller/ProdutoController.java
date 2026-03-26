package com.strutiva.controller;

import com.strutiva.model.Produto;
import com.strutiva.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // GET - listar todos
    @GetMapping
    public List<Produto> listar() {
        return produtoService.listarTodos();
    }

    // GET - buscar por id
    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    // POST - criar
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    // PUT - atualizar
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizar(id, produto);
    }

    // DELETE - remover
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }

    // GET - estoque baixo
    @GetMapping("/estoque-baixo")
    public List<Produto> estoqueBaixo(@RequestParam int limite) {
        return produtoService.estoqueBaixo(limite);
    }
}
