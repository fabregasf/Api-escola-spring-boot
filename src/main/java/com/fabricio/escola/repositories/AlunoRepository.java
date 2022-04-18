package com.fabricio.escola.repositories;

import com.fabricio.escola.models.AlunoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AlunoRepository extends MongoRepository<AlunoModel, String> {
    
    @Query(value="{name:'?0'}")
    AlunoModel findItemByName(String name);
	
	@Query(value="{codmatricula:'?0'}")
	AlunoModel findItemByMatricula(int matricula);

    public long count();

}