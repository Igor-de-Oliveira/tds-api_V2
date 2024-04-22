package com.projeto.tdsapi.service;

import com.projeto.tdsapi.Repository.LocalRepository;
import com.projeto.tdsapi.model.Local;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    public Local atualizar(@PathVariable Long id_local, @RequestBody Local local){
        Local localSalva = this.localRepository.findById(id_local).orElseThrow(() -> new EmptyResultDataAccessException(1));

        BeanUtils.copyProperties(local, localSalva, "id_Local");

        return this.localRepository.save(localSalva);
    }
}
