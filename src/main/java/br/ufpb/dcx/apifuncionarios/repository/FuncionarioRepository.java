package br.ufpb.dcx.apifuncionarios.repository;

import br.ufpb.dcx.apifuncionarios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    boolean existsByCpf(String cpf);
}
