package com.projeto.biblioteca.controller;

import org.springframework.web.bind.annotation.RestController;

import com.projeto.biblioteca.model.Livro;
import com.projeto.biblioteca.service.LivroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("biblioteca")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping("/livro")
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) throws Exception {
        Livro livroNovo = livroService.cadastrarLivro(livro);
        return ResponseEntity.ok().body(livroNovo);
    }

    @GetMapping("/livros")
    public ResponseEntity<List<Livro>> listarLivros() {
        List<Livro> livros = livroService.listarLivros();
        return ResponseEntity.ok().body(livros);
    }

    @PutMapping("/livro/{idLivro}")
    public ResponseEntity<Livro> alterarLivro(@PathVariable Long idLivro, @RequestBody Livro livro) throws Exception {
        Livro livroAlterado = livroService.alterarLivro(idLivro, livro);
        return ResponseEntity.ok().body(livroAlterado);
    }

    @DeleteMapping("/livro/{idLivro}")
    public void excluirLivro(@PathVariable Long idLivro) {
        livroService.excluirLivro(idLivro);
    }

    @GetMapping("/livro/{idLivro}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long idLivro) {
        Livro livroId = livroService.buscarLivroPorId(idLivro);
        return ResponseEntity.ok().body(livroId);
    }

    @GetMapping("/livro")
    public ResponseEntity<List<Livro>> buscarLivroPorTitulo(@RequestParam String titulo) {
        List<Livro> livroTitulo = livroService.buscarLivroPorTitulo(titulo);
        return ResponseEntity.ok().body(livroTitulo);
    }
}
