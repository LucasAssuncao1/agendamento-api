
package com.lucas.agendamento_api.business.services;

import org.springframework.stereotype.Service;

import com.lucas.agendamento_api.infrastructure.repositories.AgendamentoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    

}
