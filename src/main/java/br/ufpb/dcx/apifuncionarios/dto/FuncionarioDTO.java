package br.ufpb.dcx.apifuncionarios.dto;

import br.ufpb.dcx.apifuncionarios.validation.CPF;
import br.ufpb.dcx.apifuncionarios.validation.Telefone;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {
    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String cargo;

    @NotBlank
    @Telefone
    private String telefone;
}
