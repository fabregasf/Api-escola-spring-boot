package com.fabricio.escola.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.util.List;
import java.util.UUID;

@Document(collection = "professores")
public class ProfessorModel {

        @Id
        private String id = UUID.randomUUID().toString();

        private String nome;
        private int idade;
        private String email;
		
		private List<String>  disciplinanome;

		private int periodo;

        public ProfessorModel(){};

        public ProfessorModel( String name, int idade, String email, List<String> disciplinas) {
            super();
            this.nome = name;
            this.idade = idade;
            this.email = email;
            this.disciplinanome = disciplinas;
        }

        public String toString(){
            return "[Id = "+id+" nome = "+nome+" idade = "+idade+" .";
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

    public void setDisciplinanome(List<String> disciplinanome) {
        this.disciplinanome = disciplinanome;
    }
}