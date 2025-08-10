package com.lucas.agendamento_api.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record AgendamentoRequest(
                                String emailDestinatario,
                                String telefoneDestinatario,
                                String mensagem,
                                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                                LocalDateTime dataHoraAgendamento

) {

}
