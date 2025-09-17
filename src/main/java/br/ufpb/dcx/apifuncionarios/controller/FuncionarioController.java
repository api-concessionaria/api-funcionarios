package br.ufpb.dcx.apifuncionarios.controller;

import br.ufpb.dcx.apifuncionarios.dto.FuncionarioDTO;
import br.ufpb.dcx.apifuncionarios.mappers.FuncionarioMapper;
import br.ufpb.dcx.apifuncionarios.models.Funcionario;
import br.ufpb.dcx.apifuncionarios.services.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FuncionarioController {

    private FuncionarioService funcionarioService;
    private FuncionarioMapper funcionarioMapper;

    public FuncionarioController(FuncionarioService funcionarioService, FuncionarioMapper funcionarioMapper) {
        this.funcionarioService = funcionarioService;
        this.funcionarioMapper = funcionarioMapper;
    }

    @GetMapping(path = "/funcionarios")
    public List<Funcionario> getFuncionarios() {
        return this.funcionarioService.getFuncionarios();
    }

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
