package br.ufpb.dcx.apifuncionarios.services;

import br.ufpb.dcx.apifuncionarios.models.Funcionario;
import br.ufpb.dcx.apifuncionarios.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario listarFuncionarios(Long id) {
        return funcionarioRepository.findById(id).get();
    }

    public Funcionario criarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {
        Funcionario funcionarioAtualizado = this.funcionarioRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Funcionário não encontrado, verifique o ID: " + id));
        funcionarioAtualizado.setFuncionarioId(funcionario.getFuncionarioId());
        return funcionarioRepository.save(funcionarioAtualizado);
    }

    public void deletarFuncionario(Long id) {
        if(!funcionarioRepository.existsById(id)) {
            throw new NoSuchElementException("Funcionário não encontrado, verifique o id:" + id);
        }
        funcionarioRepository.deleteById(id);
    }
}
