package com.projeto.tdsapi.Resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.projeto.tdsapi.Repository.LocalRepository;
import com.projeto.tdsapi.event.RecursoCriadEvent;
import com.projeto.tdsapi.model.Local;
import com.projeto.tdsapi.service.LocalService;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("/locais")
public class LocalResource {

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private LocalService localService;

    @GetMapping
    public List<Local> Listar() {
        return localRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Local> Criar(@RequestBody @Valid Local local, @NotNull HttpServletResponse response) {
        Local localSalva = localRepository.save(local);

        publisher.publishEvent(new RecursoCriadEvent(this, response, localSalva.getId_Local()));

        return ResponseEntity.status(HttpStatus.CREATED).body(localSalva);
    }

    @GetMapping("/{id_Local}")
    public ResponseEntity<?> buscaCodigo(@PathVariable Long id_Local){
        Optional<Local> local = this.localRepository.findById(id_Local);
        return local.isPresent() ? ResponseEntity.ok(local) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_Local}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id_Local){
        this.localRepository.deleteById(id_Local);
    }

    @PutMapping("/{id_Local}")
    public ResponseEntity<Local> atualizar(@PathVariable Long id_Local, @Valid @RequestBody Local local){
        Local localSalva = localService.atualizar(id_Local, local);
        return ResponseEntity.ok(localSalva);
    }

}
