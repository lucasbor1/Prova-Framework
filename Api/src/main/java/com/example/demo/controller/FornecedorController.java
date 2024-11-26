package com.example.demo.controller;

import com.example.demo.entity.Fornecedor;
import com.example.demo.repository.FornecedorRepository;
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
@CrossOrigin(origins="http://127.0.0.1:5500")
@RequestMapping("/fornecedores") 
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

  
    @GetMapping
    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable long id) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);

        if (fornecedor.isPresent()) {
            return new ResponseEntity<>(fornecedor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Response<Fornecedor>> criar(@Valid @RequestBody Fornecedor fornecedor, BindingResult result) {
        Response<Fornecedor> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        fornecedorRepository.save(fornecedor);
        response.setData(fornecedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Fornecedor>> atualizar(@PathVariable long id, @Valid @RequestBody Fornecedor novoFornecedor, BindingResult result) {
        Response<Fornecedor> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Optional<Fornecedor> fornecedorExistente = fornecedorRepository.findById(id);

        if (fornecedorExistente.isPresent()) {
            Fornecedor fornecedor = fornecedorExistente.get();
            fornecedor.setNome(novoFornecedor.getNome());
            fornecedor.setContato(novoFornecedor.getContato());
            fornecedor.setCidade(novoFornecedor.getCidade());
            fornecedor.setCnpj(novoFornecedor.getCnpj());
            fornecedorRepository.save(fornecedor);
            response.setData(fornecedor);
            return ResponseEntity.ok(response);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);

        if (fornecedor.isPresent()) {
            fornecedorRepository.delete(fornecedor.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
