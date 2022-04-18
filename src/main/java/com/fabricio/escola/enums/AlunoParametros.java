package com.fabricio.escola.enums;

public enum AlunoParametros {

    ATIVO ("Aluno está ativo"),
    INATIVO_MATRICULADO ("Aluno está inativo, matricula trancada");

    private String mensagem;

    AlunoParametros(String mensagem){
        this.mensagem = mensagem;
    }

}
