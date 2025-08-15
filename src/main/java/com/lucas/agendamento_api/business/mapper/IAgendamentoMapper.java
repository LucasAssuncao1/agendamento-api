package com.lucas.agendamento_api.business.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import com.lucas.agendamento_api.controller.dto.AgendamentoRequest;
import com.lucas.agendamento_api.controller.dto.AgendamentoResponse;
import com.lucas.agendamento_api.infrastructure.entities.Agendamento;


@Mapper(componentModel = "spring")
public interface IAgendamentoMapper {

    Agendamento toEntity (AgendamentoRequest agendamento);

    AgendamentoResponse toResponse(Agendamento agendamento);

    @Mapping(target = "dataHoraModificacao", expression = "java(LocalDateTime.now())")
    @Mapping(target = "statusNotificacao", expression = "java(StatusAgendamentoEnum.CANCELADO)" )
    Agendamento toEntityCancelamento (Agendamento agendamento);

    default Page<AgendamentoResponse> toResponsePage (Page<Agendamento> agendamentoPage){
        return agendamentoPage.map(agendamento -> this.toResponse(agendamento));
    }

}
