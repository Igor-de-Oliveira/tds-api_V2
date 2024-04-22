package com.projeto.tdsapi.Resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.projeto.tdsapi.event.RecursoCriadEvent;
import com.projeto.tdsapi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.tdsapi.Repository.UsuarioRepository;
import com.projeto.tdsapi.model.Usuario;

import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/usuarios")
public class UsurioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> Listar() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid  @RequestBody Usuario usuario, HttpServletResponse response) {
        Usuario usuarioSalva = usuarioRepository.save(usuario);

        publisher.publishEvent(new RecursoCriadEvent(this, response, usuarioSalva.getId_Usuario()));

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalva);
    }

    @GetMapping("/{id_Usuario}")
    public ResponseEntity<?> buscaCodigo(@PathVariable Long id_Usuario) {
        Optional<Usuario> usuario = this.usuarioRepository.findById(id_Usuario);
        return usuario.isPresent() ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id_Usuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id_Usuario) {
        this.usuarioRepository.deleteById(id_Usuario);
    }

    @PutMapping("/{id_Usuario}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id_Usuario, @Valid @RequestBody Usuario usuario) {
        Usuario usuarioSalva = usuarioService.atualizar(id_Usuario, usuario);
        return ResponseEntity.ok(usuarioSalva);
    }
}
