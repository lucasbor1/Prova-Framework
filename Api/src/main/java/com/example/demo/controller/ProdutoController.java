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
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;


    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

  
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto>GetBydId(@PathVariable long id){
		
		Optional<Produto> produto = produtoRepository.findById(id);
		
		if(produto.isPresent())
			return new ResponseEntity<Produto>(produto.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@PostMapping("/produto")
	public ResponseEntity<Response<Produto>> Post(@Valid @RequestBody Produto produto, BindingResult result){
		
		Response<Produto>response = new Response<Produto>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		produtoRepository.save(produto);
		response.setData(produto);
		return ResponseEntity.ok(response);
	}

   
	@PutMapping("/pessoa/{id}")
	public ResponseEntity<Response<Produto>>Put(@PathVariable long id,@Valid @RequestBody Produto newProduto, BindingResult result){
		
		Optional<Produto> oldProduto = produtoRepository.findById(id);
		Response<Produto> response = new Response<Produto>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		if(oldProduto.isPresent()) {
			Produto produto = oldProduto.get();
			produto.setNome(newProduto.getNome());			
			produto.setPreco(newProduto.getPreco());
			produto.setQuantidade(newProduto.getQuantidade());
			produtoRepository.save(produto);
			response.setData(produto);
			
			return ResponseEntity.ok(response);			
		}
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
  

	@DeleteMapping("/produto/{id}")
	public ResponseEntity<Object>Delete(@PathVariable long id){
		
		Optional<Produto>produto = produtoRepository.findById(id);
		
		if(produto.isPresent()){
			produtoRepository.delete(produto.get());
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
