package br.ufpb.dcx.apifuncionarios.service;

import br.ufpb.dcx.apifuncionarios.excepition.FuncionarioNotFoundException;
import br.ufpb.dcx.apifuncionarios.excepition.FuncionariosIsExistException;
import br.ufpb.dcx.apifuncionarios.model.Funcionario;
import br.ufpb.dcx.apifuncionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario getFuncionario(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new FuncionarioNotFoundException("Funcionário não encontrado!"));
    }

    public Funcionario criarFuncionario(Funcionario funcionario) {
        if (funcionarioRepository.existsByCpf(funcionario.getCpf())) {
            throw new FuncionariosIsExistException("Já existe um funcionário cadastrado com esse cpf!");
        }
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {
        Funcionario funcionarioAtualizado = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException("Funcionário não encontrado, verifique o ID: " + id));
        funcionarioAtualizado.setTelefone(funcionario.getTelefone());
        funcionarioAtualizado.setCpf(funcionario.getCpf());
        funcionarioAtualizado.setNome(funcionario.getNome());
        funcionarioAtualizado.setEmail(funcionario.getEmail());
        funcionarioAtualizado.setCargo(funcionario.getCargo());
        return funcionarioRepository.save(funcionarioAtualizado);
    }

    public void deletarFuncionario(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new FuncionarioNotFoundException("Funcionário não encontrado!"));
        funcionarioRepository.delete(funcionario);
    }
}
