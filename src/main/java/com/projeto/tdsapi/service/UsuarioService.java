package com.projeto.tdsapi.service;

import com.projeto.tdsapi.Repository.UsuarioRepository;
import com.projeto.tdsapi.model.Usuario;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario atualizar(Long id_Usuario, Usuario usuario){
        Usuario usuarioSalva = this.usuarioRepository.findById(id_Usuario).orElseThrow(() -> new EmptyResultDataAccessException(1));

        BeanUtils.copyProperties(usuario, usuarioSalva, "id_Usuario");

        return this.usuarioRepository.save(usuarioSalva);
    }
}
