package com.fabricio.escola.services;

import com.fabricio.escola.models.AlunoModel;
import com.fabricio.escola.models.ProfessorModel;
import com.fabricio.escola.repositories.AlunoRepository;
import com.fabricio.escola.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository profrepo;

    @ResponseBody
    public Page<ProfessorModel> listaProfessores(Pageable pageable){   return profrepo.findAll(pageable);    }

    public Page<ProfessorModel> findByDisciplina(String disciplina,Pageable page){
        Pageable custompage = PageRequest.of(page.getPageNumber(), 5);
        return profrepo.findByDisciplina(disciplina, custompage);
    }

    public Page<ProfessorModel> findByName(String nome,Pageable page){
        Pageable custompage = PageRequest.of(page.getPageNumber(), 10);
        return profrepo.findItemByNome(nome, custompage);
    }

}
