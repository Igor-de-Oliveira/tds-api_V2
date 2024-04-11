package com.projeto.tdsapi.Repository;

import com.projeto.tdsapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
