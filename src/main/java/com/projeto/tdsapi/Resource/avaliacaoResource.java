package com.projeto.tdsapi.Resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.tdsapi.Repository.avaliacaoRepository;
import com.projeto.tdsapi.model.avaliacao;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/avaliacao")
public class avaliacaoResource {

    @Autowired
    private avaliacaoRepository avaliacaoRepository;

    @GetMapping
    public List<avaliacao> Listar() {
        return avaliacaoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<avaliacao> criar(@RequestBody avaliacao avaliacao, @NotNull HttpServletResponse response) {
        avaliacao avaliacaoSalva = avaliacaoRepository.save(avaliacao);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id_avaliacao}").buildAndExpand(avaliacaoSalva.getIdavaliacao()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(avaliacaoSalva);
    }

    @GetMapping("/{id_avaliacao}")
    public ResponseEntity<?> buescaCodigo(@PathVariable Long id_avaliacao){
        Optional<avaliacao> avaliacao = this.avaliacaoRepository.findById(id_avaliacao);
        return avaliacao.isPresent() ? ResponseEntity.ok(avaliacao) : ResponseEntity.notFound().build();
    }
}
