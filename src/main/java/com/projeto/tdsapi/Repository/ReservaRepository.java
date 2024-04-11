package com.projeto.tdsapi.Repository;

import com.projeto.tdsapi.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
