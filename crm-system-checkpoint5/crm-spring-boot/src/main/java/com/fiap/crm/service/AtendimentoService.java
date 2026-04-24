package com.fiap.crm.service;

import com.fiap.crm.model.enums.AreaDeInteresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtendimentoService {

    @Autowired
    private CRMService crmService;

    public void processarMensagemWhatsApp(String canal, String nome, String email, String tel, AreaDeInteresse area, boolean interesseOrcamento) {
        System.out.println("[Chatbot " + canal + "]: Processando dúvida...");
        if (interesseOrcamento) {
            System.out.println("[Chatbot]: Cliente interessado. Encaminhando para vendas.");
            crmService.registrarInteresse(nome, email, tel, area);
        }
    }

    public void processarChamadaTelefonica(String nome, String email, String tel, AreaDeInteresse area) {
        System.out.println("[Vendas]: Atendimento telefônico iniciado. Registrando prospectante.");
        crmService.registrarInteresse(nome, email, tel, area);
    }

    public void processarEmailSAC(String nome, String email, String tel, AreaDeInteresse area) {
        System.out.println("[SAC]: E-mail recebido. Registrando no sistema.");
        crmService.registrarInteresse(nome, email, tel, area);
    }
}
