package com.lucas.agendamento_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.agendamento_api.business.services.AgendamentoService;
import com.lucas.agendamento_api.controller.dto.AgendamentoRequest;
import com.lucas.agendamento_api.controller.dto.AgendamentoResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService service;

    @PostMapping
    public ResponseEntity<AgendamentoResponse> gravarAgendamento (@RequestBody AgendamentoRequest request){

        return ResponseEntity.ok(service.gravarAgendamento(request));
    }

}
