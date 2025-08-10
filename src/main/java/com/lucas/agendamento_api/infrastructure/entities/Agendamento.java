package com.lucas.agendamento_api.infrastructure.entities;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import com.lucas.agendamento_api.infrastructure.enums.StatusAgendamentoEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "agendamento")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String emailDestinatario;
    private String telefoneDestinatario;
    private LocalDateTime dataHoraEnvio;
    private LocalDateTime dataHoraAgendamento;
    private LocalDateTime dataHoraModificacao;
    private String mensagem;
    private StatusAgendamentoEnum statusNotificacao;


    @PrePersist
    private void prePersist (){

         this.dataHoraAgendamento = LocalDateTime.now();
        this.statusNotificacao = StatusAgendamentoEnum.ENVIADO;

    }


}
