package br.ufpb.dcx.apifuncionarios.controller;

import br.ufpb.dcx.apifuncionarios.dto.FuncionarioDTO;
import br.ufpb.dcx.apifuncionarios.mappers.FuncionarioMapper;
import br.ufpb.dcx.apifuncionarios.models.Funcionario;
import br.ufpb.dcx.apifuncionarios.services.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; // <-- ADICIONADO
import org.springframework.web.bind.annotation.*;

import java.util.HashMap; // <-- ADICIONADO
import java.util.List;
import java.util.Map; // <-- ADICIONADO

@RestController
@RequestMapping("/api")
public class FuncionarioController {

    private FuncionarioService funcionarioService;
    private FuncionarioMapper funcionarioMapper;

    public FuncionarioController(FuncionarioService funcionarioService, FuncionarioMapper funcionarioMapper) {
        this.funcionarioService = funcionarioService;
        this.funcionarioMapper = funcionarioMapper;
    }

    // --- ESTE FOI O MÉTODO ALTERADO ---
    @GetMapping(path = "/funcionarios")
    public ResponseEntity<Map<String, Object>> getFuncionarios() {
        // Busca a lista de funcionários como antes
        List<Funcionario> funcionarios = this.funcionarioService.getFuncionarios();

        // Obtém o ID único do container (hostname)
        String instanceId;
        try {
            instanceId = java.net.InetAddress.getLocalHost().getHostName();
        } catch (java.net.UnknownHostException e) {
            instanceId = "id-desconhecido";
            e.printStackTrace();
        }

        // Cria o novo objeto de resposta
        Map<String, Object> response = new HashMap<>();
        response.put("instance_id", instanceId);
        response.put("funcionarios", funcionarios);

        return ResponseEntity.ok(response);
    }
    // --- FIM DA ALTERAÇÃO ---



    @GetMapping(path = "/funcionarios/{funcionarioId}")
    public Funcionario getFuncionario(@PathVariable Long funcionarioId) {
        return this.funcionarioService.getFuncionario(funcionarioId);
    }

    @PostMapping(path = "/funcionarios")
    public FuncionarioDTO adicionarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionarioCriado = this.funcionarioService.criarFuncionario(this.funcionarioMapper.toEntity(funcionarioDTO));
        return this.funcionarioMapper.toDTO(funcionarioCriado);
    }

    @PutMapping(path = "/funcionarios/{funcionarioId}")
    public FuncionarioDTO atualizarFuncionario(@PathVariable Long funcionarioId, @RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionarioAtualizado = this.funcionarioService.atualizarFuncionario(funcionarioId, this.funcionarioMapper.toEntity(funcionarioDTO));
        return this.funcionarioMapper.toDTO(funcionarioAtualizado);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/funcionarios/{funcionarioId}")
    public void removerFuncionario(@PathVariable Long funcionarioId) {
        this.funcionarioService.deletarFuncionario(funcionarioId);
    }

}