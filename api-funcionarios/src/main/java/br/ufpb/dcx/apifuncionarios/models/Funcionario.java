package br.ufpb.dcx.apifuncionarios.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tbFuncionarios")
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long funcionarioId;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "cpf")
    private String cpf;

    @NotBlank
    @Column(name = "endereco")
    private String endereco;

    @NotBlank
    @Column(name = "telefone")
    private String telefone;

    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "cargo")
    private String cargo;

    @NotNull
    private Date dataCadastro;

    @NotNull
    @Column(name = "salario")
    private double salario;
}
