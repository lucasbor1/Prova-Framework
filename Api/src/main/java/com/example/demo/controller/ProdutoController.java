package com.example.demo.controller;

import com.example.demo.entity.Produto;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable long id) {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isPresent()) {
            return new ResponseEntity<>(produto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Response<Produto>> criar(@Valid @RequestBody Produto produto, BindingResult result) {
        Response<Produto> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        produtoRepository.save(produto);
        response.setData(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Produto>> atualizar(@PathVariable long id, @Valid @RequestBody Produto novoProduto, BindingResult result) {
        Response<Produto> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Optional<Produto> produtoExistente = produtoRepository.findById(id);

        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setNome(novoProduto.getNome());
            produto.setPreco(novoProduto.getPreco());
            produto.setQuantidade(novoProduto.getQuantidade());
            produtoRepository.save(produto);
            response.setData(produto);
            return ResponseEntity.ok(response);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isPresent()) {
            produtoRepository.delete(produto.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
