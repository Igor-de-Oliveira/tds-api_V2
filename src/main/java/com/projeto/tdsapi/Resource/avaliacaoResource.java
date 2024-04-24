package com.projeto.tdsapi.Resource;

import java.util.List;
import java.util.Optional;

import com.projeto.tdsapi.event.RecursoCriadEvent;
import com.projeto.tdsapi.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.tdsapi.Repository.avaliacaoRepository;
import com.projeto.tdsapi.model.avaliacao;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/avaliacao")
public class avaliacaoResource {

    @Autowired
    private avaliacaoRepository avaliacaoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public List<avaliacao> listar(){
        return avaliacaoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<avaliacao> criar(@Valid @RequestBody avaliacao avaliacao, @NotNull HttpServletResponse response) {
        avaliacao avaliacaoSalva = avaliacaoRepository.save(avaliacao);

        publisher.publishEvent(new RecursoCriadEvent(this, response, avaliacaoSalva.getIdavaliacao()));

        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoSalva);
    }

    @GetMapping("/{id_avaliacao}")
    public ResponseEntity<?> buescaCodigo(@PathVariable Long id_avaliacao){
        Optional<avaliacao> avaliacao = this.avaliacaoRepository.findById(id_avaliacao);
        return avaliacao.isPresent() ? ResponseEntity.ok(avaliacao) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_avaliacao}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id_avaliacao){
        this.avaliacaoRepository.deleteById(id_avaliacao);
    }

    @PutMapping("/{id_avaliacao}")
    public ResponseEntity<avaliacao> atualizar(@PathVariable Long id_avaliacao, @Valid @RequestBody avaliacao avaliacao){
        avaliacao avaliacaoSalva = avaliacaoService.atualizar(id_avaliacao, avaliacao);
        return ResponseEntity.ok(avaliacaoSalva);
    }


}
