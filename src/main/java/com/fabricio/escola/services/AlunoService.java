package com.fabricio.escola.services;

import com.fabricio.escola.models.AlunoModel;
import com.fabricio.escola.models.ProfessorModel;
import com.fabricio.escola.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunorepo;

    @ResponseBody
    public List<AlunoModel> listaAlunos(Pageable pageable){
        // chamou método padrão Mongodb
        return alunorepo.findAll();
    }

}
