package com.projeto.tdsapi.service;

import com.projeto.tdsapi.Repository.FuncionarioRepository;
import com.projeto.tdsapi.model.Funcionario;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario atualizar(@PathVariable Long id_funcionario, @RequestBody Funcionario funcionario){
        Funcionario funcionarioSalvo = this.funcionarioRepository.findById(id_funcionario).orElseThrow(() -> new EmptyResultDataAccessException(1));

        BeanUtils.copyProperties(funcionario, funcionarioSalvo, "id_funcionario");

        return this.funcionarioRepository.save(funcionarioSalvo);
    }
}
