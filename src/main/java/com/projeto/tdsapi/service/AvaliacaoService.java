package com.projeto.tdsapi.service;

import com.projeto.tdsapi.model.avaliacao;
import com.projeto.tdsapi.Repository.avaliacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AvaliacaoService {

    @Autowired
    private avaliacaoRepository avaliacaoRepository;

    public avaliacao atualizar(@PathVariable Long id_avaliacao, @RequestBody avaliacao avaliacao){
        avaliacao avaliacaoSalva = this.avaliacaoRepository.findById(id_avaliacao).orElseThrow(() -> new EmptyResultDataAccessException(1));

        BeanUtils.copyProperties(avaliacao, avaliacaoSalva, "id_avaliacao");

        return this.avaliacaoRepository.save(avaliacaoSalva);
    }
}
