
package com.lucas.agendamento_api.business.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lucas.agendamento_api.business.mapper.IAgendamentoMapper;
import com.lucas.agendamento_api.controller.dto.AgendamentoRequest;
import com.lucas.agendamento_api.controller.dto.AgendamentoResponse;
import com.lucas.agendamento_api.infrastructure.entities.Agendamento;
import com.lucas.agendamento_api.infrastructure.exceptions.NotFoundException;
import com.lucas.agendamento_api.infrastructure.repositories.AgendamentoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final IAgendamentoMapper mapper;

    public Page<AgendamentoResponse> listarAgendamentos(Pageable pageable) {
        return mapper.toResponsePage(agendamentoRepository.findAll(pageable));
    }

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

    public void cancelarAgendamento(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Agendamento não encontrado com o id " + id));

        
        agendamentoRepository.save(mapper.toEntityCancelamento(agendamento)); 
    }

    public void deletarTodos() {
        agendamentoRepository.deleteAll();
    }
} 
