package com.fabricio.escola.repositories;

import com.fabricio.escola.models.ProfessorModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProfessorRepository extends MongoRepository<ProfessorModel, String> {
    
    @Query(value="{nome:'?0'}")
    Page<ProfessorModel> findItemByNome(String nome, Pageable page);
    
    @Query(value="{disciplinanome:'?0'}")
    Page<ProfessorModel> findByDisciplina(String disciplinanome, Pageable page);


    public long count();

}