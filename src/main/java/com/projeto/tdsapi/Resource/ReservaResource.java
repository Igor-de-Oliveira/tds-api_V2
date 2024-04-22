package com.projeto.tdsapi.Resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.projeto.tdsapi.event.RecursoCriadEvent;
import com.projeto.tdsapi.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.tdsapi.Repository.ReservaRepository;
import com.projeto.tdsapi.model.Reserva;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/reservas")
public class ReservaResource {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    public ReservaService reservaService;

    @GetMapping
    public List<Reserva> Listar() {
        return reservaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Reserva> Criar(@Valid @RequestBody Reserva reserva, HttpServletResponse response) {
        Reserva reservaSalva = reservaRepository.save(reserva);

        publisher.publishEvent(new RecursoCriadEvent(this, response, reservaSalva.getId_Reserva()));

        return ResponseEntity.status(HttpStatus.CREATED).body(reservaSalva);
    }

    @GetMapping("/{id_Reserva}")
    public ResponseEntity<?> buscaCodigo(@PathVariable Long id_Reserva) {
        Optional<Reserva> reserva = this.reservaRepository.findById(id_Reserva);
        return reserva.isPresent() ? ResponseEntity.ok(reserva) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_Reserva}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id_Reserva) {
        this.reservaRepository.deleteById(id_Reserva);
    }

    @PutMapping("/{id_Reserva}")
    public ResponseEntity<Reserva> atualizar(@PathVariable Long id_Reserva, @Valid @RequestBody Reserva reserva) {
        Reserva reservaSalva = reservaService.atualizar(id_Reserva, reserva);
        return ResponseEntity.ok(reservaSalva);
    }
}
