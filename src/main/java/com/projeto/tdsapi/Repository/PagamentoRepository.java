package com.projeto.tdsapi.Repository;

import com.projeto.tdsapi.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
