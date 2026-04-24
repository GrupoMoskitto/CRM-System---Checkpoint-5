package com.fiap.crm.service;

import com.fiap.crm.model.entities.*;
import com.fiap.crm.model.enums.*;
import com.fiap.crm.model.vo.Endereco;
import com.fiap.crm.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class CRMService {

    @Autowired private VendedorRepository vendedorRepo;
    @Autowired private AtendenteRepository atendenteRepo;
    @Autowired private ProspectanteRepository prospectanteRepo;
    @Autowired private ClienteRepository clienteRepo;
    @Autowired private UsuarioRepository usuarioRepo;
    @Autowired private ContratoRepository contratoRepo;

    // --- CRUD Vendedor ---
    public Vendedor salvarVendedor(Vendedor v) { return vendedorRepo.save(v); }
    public List<Vendedor> listarVendedores() { return vendedorRepo.findAll(); }
    public void deletarVendedor(Long id) { vendedorRepo.deleteById(id); }

    // --- CRUD Atendente ---
    public Atendente salvarAtendente(Atendente a) { return atendenteRepo.save(a); }
    public List<Atendente> listarAtendentes() { return atendenteRepo.findAll(); }

    // --- Lógica de Prospectante e Chatbot ---
    public Prospectante registrarInteresse(String nome, String email, String telefone, AreaDeInteresse area) {
        Prospectante p = new Prospectante(null, nome, email, telefone, area);
        return prospectanteRepo.save(p);
    }

    @Transactional
    public Cliente converterParaCliente(Long prospectanteId, String cpf, Endereco endereco) {
        Prospectante p = prospectanteRepo.findById(prospectanteId)
                .orElseThrow(() -> new RuntimeException("Prospectante não encontrado"));
        
        Cliente c = new Cliente(null, p.getNome(), cpf, p.getEmail(), p.getTelefone(), endereco, Status.EM_ATENDIMENTO);
        Cliente salvo = clienteRepo.save(c);
        
        prospectanteRepo.delete(p);
        return salvo;
    }

    // --- CRUD Contrato ---
    @Transactional
    public Contrato fecharContrato(Long clienteId, Long vendedorId, Double valor, String descricao) {
        Cliente c = clienteRepo.findById(clienteId).orElseThrow();
        Vendedor v = vendedorRepo.findById(vendedorId).orElseThrow();
        
        Contrato contrato = new Contrato(null, c, v, valor, LocalDate.now(), descricao);
        c.setStatus(Status.CONCLUIDO);
        clienteRepo.save(c);
        
        return contratoRepo.save(contrato);
    }

    // --- CRUD Usuário ---
    public Usuario cadastrarUsuario(Usuario u) { return usuarioRepo.save(u); }
    public List<Usuario> listarUsuarios() { return usuarioRepo.findAll(); }
}
