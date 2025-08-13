package com.lucas.agendamento_api.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucas.agendamento_api.infrastructure.enums.StatusAgendamentoEnum;

public record AgendamentoResponse(
                                Long id,
                                String emailDestinatario,
                                String telefoneDestinatario,
                                String mensagem,
                                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                                LocalDateTime dataHoraAgendamento,
                                StatusAgendamentoEnum statusNotificacao
) {

}
