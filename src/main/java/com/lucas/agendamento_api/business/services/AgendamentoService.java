
package com.lucas.agendamento_api.business.services;

import org.springframework.stereotype.Service;

import com.lucas.agendamento_api.business.mapper.IAgendamentoMapper;
import com.lucas.agendamento_api.controller.dto.AgendamentoRequest;
import com.lucas.agendamento_api.controller.dto.AgendamentoResponse;
import com.lucas.agendamento_api.infrastructure.entities.Agendamento;
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

}
