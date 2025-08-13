package com.lucas.agendamento_api.business.mapper;

import org.mapstruct.Mapper;

import com.lucas.agendamento_api.controller.dto.AgendamentoRequest;
import com.lucas.agendamento_api.controller.dto.AgendamentoResponse;
import com.lucas.agendamento_api.infrastructure.entities.Agendamento;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IAgendamentoMapper {

    public Agendamento toEntity (AgendamentoRequest agendamento);

    public AgendamentoResponse toResponse(Agendamento agendamento);

}
