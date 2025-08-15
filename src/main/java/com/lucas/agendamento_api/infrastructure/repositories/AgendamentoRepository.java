package com.lucas.agendamento_api.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.agendamento_api.infrastructure.entities.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{


}
