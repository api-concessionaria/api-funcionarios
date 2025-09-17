package br.ufpb.dcx.apifuncionarios.repositories;

import br.ufpb.dcx.apifuncionarios.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
