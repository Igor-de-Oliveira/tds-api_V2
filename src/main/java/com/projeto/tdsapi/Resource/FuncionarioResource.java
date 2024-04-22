package com.projeto.tdsapi.Resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.projeto.tdsapi.event.RecursoCriadEvent;
import com.projeto.tdsapi.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.tdsapi.Repository.FuncionarioRepository;
import com.projeto.tdsapi.model.Funcionario;

import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> Listar(){
        return funcionarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Funcionario> Criar(@Valid  @RequestBody Funcionario funcionario, HttpServletResponse response) {
        Funcionario funcionarioSalva = funcionarioRepository.save(funcionario);

        publisher .publishEvent(new RecursoCriadEvent(this, response, funcionarioSalva.getId_Funcionario()));

        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalva);
    }

    @GetMapping("/{id_Funcionario}")
    public ResponseEntity<?> buscaCodigo(@PathVariable Long id_Funcionario) {
        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(id_Funcionario);
        return funcionario.isPresent() ? ResponseEntity.ok(funcionario) : ResponseEntity.notFound().build();
    }

    @DeleteMapping ("/{id_Funcionario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id_Funcionario) {
        this.funcionarioRepository.deleteById(id_Funcionario);
    }

    @PutMapping("/{id_Funcionario}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id_Funcionario, @Valid @RequestBody Funcionario funcionario) {
        Funcionario funcionarioSalva = funcionarioService.atualizar(id_Funcionario, funcionario);
        return ResponseEntity.ok(funcionarioSalva);
    }
}
