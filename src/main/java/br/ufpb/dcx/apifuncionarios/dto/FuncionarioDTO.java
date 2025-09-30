package br.ufpb.dcx.apifuncionarios.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FuncionarioDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @Email
    private String email;

    @NotBlank
    private String cargo;
}
