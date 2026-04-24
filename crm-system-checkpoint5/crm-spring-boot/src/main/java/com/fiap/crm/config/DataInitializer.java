package com.fiap.crm.config;

import com.fiap.crm.model.entities.*;
import com.fiap.crm.model.enums.*;
import com.fiap.crm.model.vo.Endereco;
import com.fiap.crm.service.CRMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CRMService crmService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n--- Iniciando Demonstração de CRUD e Persistência (Checkpoint 5) ---");

        // 1. Cadastrar Vendedor
        Endereco endVendedor = new Endereco("Av. Paulista", "1000", "Andar 10", "Bela Vista", "São Paulo", "SP", "01310-100");
        Vendedor v1 = new Vendedor(null, "João Vendedor", "123.456.789-00", "joao@vendas.com", "(11) 99999-0000", endVendedor, Qualificacao.TECNICO);
        v1 = crmService.salvarVendedor(v1);
        System.out.println("Vendedor cadastrado: " + v1.getNome());

        // 2. Cadastrar Atendente
        Atendente a1 = new Atendente(null, "Maria Atendente", "987.654.321-11", "maria@sac.com", "(11) 88888-1111", endVendedor, Tipo.AUXILIAR);
        crmService.salvarAtendente(a1);
        System.out.println("Atendente cadastrado: " + a1.getNome());

        // 3. Cadastrar Usuário
        Usuario u1 = new Usuario(null, "Admin", "admin", "123456");
        crmService.cadastrarUsuario(u1);
        System.out.println("Usuário cadastrado: " + u1.getLogin());

        // 4. Fluxo de Prospectante para Cliente
        Prospectante p1 = crmService.registrarInteresse("Carlos Cliente", "carlos@email.com", "(11) 77777-2222", AreaDeInteresse.SAUDE);
        System.out.println("Prospectante registrado via Chatbot: " + p1.getNome());

        // Converter para Cliente (CRUD Update/Delete/Insert)
        Endereco endCliente = new Endereco("Rua das Flores", "50", null, "Centro", "Osasco", "SP", "06000-000");
        Cliente c1 = crmService.converterParaCliente(p1.getId(), "444.555.666-77", endCliente);
        System.out.println("Prospectante convertido para Cliente: " + c1.getNome() + " | Status: " + c1.getStatus());

        // 5. Fechar Contrato (CRUD Create)
        Contrato cont1 = crmService.fecharContrato(c1.getId(), v1.getId(), 5000.0, "Consultoria de Saúde Estética");
        System.out.println("Contrato fechado com sucesso! Valor: R$ " + cont1.getValor());
        
        System.out.println("--- Fim da Demonstração ---\n");
    }
}
