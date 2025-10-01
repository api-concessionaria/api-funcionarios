package br.ufpb.dcx.apifuncionarios.mapper;

import br.ufpb.dcx.apifuncionarios.dto.FuncionarioDTO;
import br.ufpb.dcx.apifuncionarios.model.Funcionario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    private final ModelMapper modelMapper;

    public FuncionarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FuncionarioDTO toDTO(Funcionario funcionario) {
        return modelMapper.map(funcionario, FuncionarioDTO.class);
    }

    public Funcionario toEntity(FuncionarioDTO funcionarioDTO) {
        return modelMapper.map(funcionarioDTO, Funcionario.class);
    }
}
