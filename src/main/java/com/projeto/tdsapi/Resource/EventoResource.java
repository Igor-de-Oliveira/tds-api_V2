package com.projeto.tdsapi.Resource;

import java.util.List;
import java.util.Optional;

import com.projeto.tdsapi.event.RecursoCriadEvent;
import com.projeto.tdsapi.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;

import com.projeto.tdsapi.Repository.EventoRepository;
import com.projeto.tdsapi.model.Evento;

@RestController
@RequestMapping("/eventos")
public class EventoResource {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> pesquisar(){
        return eventoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Evento> Criar(@Valid @RequestBody Evento evento, HttpServletResponse response) {
        Evento eventoSalva = eventoRepository.save(evento);

        publisher.publishEvent(new RecursoCriadEvent(this, response, eventoSalva.getId_Evento()));

        return ResponseEntity.status(HttpStatus.CREATED).body(eventoSalva);
    }

    @GetMapping("/{id_Evento}")
    public ResponseEntity<?> buscaCodigo(@PathVariable Long id_Evento) {
        Optional<Evento> evento = this.eventoRepository.findById(id_Evento);
        return evento.isPresent() ? ResponseEntity.ok(evento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_Evento}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id_Evento) {
        this.eventoRepository.deleteById(id_Evento);
    }

    @PutMapping("/{id_Evento}")
    public ResponseEntity<Evento> atualizar(@PathVariable Long id_Evento, @Valid @RequestBody Evento evento) {
        Evento eventoSalva = eventoService.atualizar(id_Evento, evento);
        return ResponseEntity.ok(eventoSalva);
    }
}
