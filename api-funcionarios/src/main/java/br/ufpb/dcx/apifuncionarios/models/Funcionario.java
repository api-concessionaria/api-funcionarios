package br.ufpb.dcx.apifuncionarios.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbFuncionarios")
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long funcionarioId;

}
