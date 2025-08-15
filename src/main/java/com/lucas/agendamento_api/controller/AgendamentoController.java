package com.lucas.agendamento_api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping()
    public ResponseEntity<Page<AgendamentoResponse>> listarAgendamentos (Pageable pageable){
        return ResponseEntity.ok(service.listarAgendamentos(pageable)); 
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponse> gravarAgendamento (@RequestBody AgendamentoRequest request){

        return ResponseEntity.ok(service.gravarAgendamento(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> buscarAgendamento (@PathVariable Long id){
        return ResponseEntity.ok(service.buscarAgendamento(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> cancelarAgendamento (@PathVariable Long id){
        service.cancelarAgendamento(id);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarTodos (){
        service.deletarTodos();
        return ResponseEntity.noContent().build();
    }

}
