package com.projeto.tdsapi.Resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.projeto.tdsapi.Repository.LocalRepository;
import com.projeto.tdsapi.model.Local;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("/locais")
public class LocalResource {

    @Autowired
    private LocalRepository localRepository;

    @GetMapping
    public List<Local> Listar() {
        return localRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Local> criar(@RequestBody Local local, @NotNull HttpServletResponse response) {
        Local localSalva = localRepository.save(local);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idLocal}").buildAndExpand(localSalva.getId_Local()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(localSalva);
    }

    @GetMapping("/{id_Local}")
    public ResponseEntity<?> buscaCodigo(@PathVariable Long id_Local){
        Optional<Local> local = this.localRepository.findById(id_Local);
        return local.isPresent() ? ResponseEntity.ok(local) : ResponseEntity.notFound().build();
    }
}
