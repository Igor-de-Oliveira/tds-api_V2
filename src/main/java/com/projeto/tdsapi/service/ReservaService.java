package com.projeto.tdsapi.service;

import com.projeto.tdsapi.Repository.ReservaRepository;
import com.projeto.tdsapi.model.Reserva;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva atualizar(@PathVariable Long id_Reserva, @RequestBody Reserva reserva){
        Reserva reservaSalva = this.reservaRepository.findById(id_Reserva).orElseThrow(() -> new EmptyResultDataAccessException(1));

        BeanUtils.copyProperties(reserva, reservaSalva, "id_Reserva");

        return this.reservaRepository.save(reservaSalva);
    }
}
