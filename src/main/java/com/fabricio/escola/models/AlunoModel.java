package com.fabricio.escola.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "alunos")
public class AlunoModel {

        @Id
		private String id = UUID.randomUUID().toString();

        private String nome;
        private int idade;
        private String email;

        private List<String> disciplinanome;
		private int periodo;
			
        public AlunoModel(String nome, int idade, String email, List<String> disciplinanome,
						  int periodo) {
            super();
            this.setNome(nome);
            this.setIdade(idade);
            this.setEmail(email);
			this.setDisciplinanome(disciplinanome);
			this.setPeriodo(periodo);
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getDisciplinanome() {
        return disciplinanome;
    }

    public void  setDisciplinanome(List<String> disciplinanome) {
        this.disciplinanome = disciplinanome;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
}