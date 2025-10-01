package br.ufpb.dcx.apifuncionarios.excepition;

public class FuncionarioNotFoundException extends RuntimeException {
    public FuncionarioNotFoundException(String message) {
        super(message);
    }
}
