
package com.lucas.agendamento_api.business.services;

import org.springframework.stereotype.Service;

import com.lucas.agendamento_api.business.mapper.IAgendamentoMapper;
import com.lucas.agendamento_api.controller.dto.AgendamentoRequest;
import com.lucas.agendamento_api.controller.dto.AgendamentoResponse;
import com.lucas.agendamento_api.infrastructure.exceptions.NotFoundException;
import com.lucas.agendamento_api.infrastructure.repositories.AgendamentoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final IAgendamentoMapper mapper;

    public AgendamentoResponse gravarAgendamento(AgendamentoRequest agendamentoRequest) {
        return mapper.toResponse(
                agendamentoRepository.save(
                        mapper.toEntity(agendamentoRequest)));

    }

    public AgendamentoResponse buscarAgendamento(Long id) {
        return mapper.toResponse(
                agendamentoRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Agendamento não encontrado com o id " + id)));

    }

}
