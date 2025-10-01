package br.ufpb.dcx.apifuncionarios.excepition;

public class FuncionariosIsExistException extends RuntimeException{
    public FuncionariosIsExistException(String message) {
        super(message);
    }
}
