package com.projeto.tdsapi.service;

import com.projeto.tdsapi.Repository.EventoRepository;
import com.projeto.tdsapi.model.Evento;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Evento atualizar(@PathVariable Long id_Evento, @RequestBody Evento evento) {
        Evento eventoSalva = this.eventoRepository.findById(id_Evento).orElseThrow(() -> new EmptyResultDataAccessException(1));

        BeanUtils.copyProperties(evento, eventoSalva, "id_Evento");

        return this.eventoRepository.save(eventoSalva);
    }
}
