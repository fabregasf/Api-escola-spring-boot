package com.fabricio.escola.controllers;

import com.fabricio.escola.models.AlunoModel;
import com.fabricio.escola.models.ProfessorModel;
import com.fabricio.escola.repositories.AlunoRepository;
import com.fabricio.escola.repositories.ProfessorRepository;
import com.fabricio.escola.services.AlunoService;
import com.fabricio.escola.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EscolaController {

    @Autowired
    ProfessorService professorService;
	@Autowired
    AlunoService alunoserv;

    // Root do sistema
    @GetMapping("/")
    public String index(){
        return "Página inicial. <br><br> Monte sua requisição para a API da seguinte forma: <br> " +
                "localhost:8080/nomeentidade/{parametros}, localhost:8080/nomeentidade/";
    }

	@GetMapping("/professores")
    public ResponseEntity<Page<ProfessorModel>> listaProfessores(@PageableDefault(size=20, sort = "Id",
            direction = Sort.Direction.DESC) Pageable pageable){

        if(professorService.listaProfessores(pageable).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(professorService.listaProfessores(pageable), HttpStatus.OK);
        }
    }

    @GetMapping("/professores/{disciplina}")
    public ResponseEntity<Page<ProfessorModel>> listaProfPorDisciplina(@PathVariable(value="disciplina")
                                                                                   String disciplina,
                                                                       Pageable pageable){

        if(professorService.findByDisciplina(disciplina,pageable).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>(professorService.findByDisciplina(disciplina,pageable),
                    HttpStatus.OK);
        }

    }

    @GetMapping("/alunotodos")
    public ResponseEntity<Page<AlunoModel>> listaAlunos(@PageableDefault(size=20, sort = "Id",
            direction = Sort.Direction.DESC) Pageable pageable){

        if(alunoserv.listaAlunos(pageable).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity(alunoserv.listaAlunos(pageable), HttpStatus.OK);
        }

    }

	
}