package com.fabricio.escola;

import com.fabricio.escola.models.AlunoModel;
import com.fabricio.escola.models.ProfessorModel;
import com.fabricio.escola.repositories.AlunoRepository;
import com.fabricio.escola.repositories.ProfessorRepository;
import com.mongodb.client.MongoClients;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@Component
public class EscolaApplication implements ApplicationRunner {

	private static final Log log = LogFactory.getLog(EscolaApplication.class);
	@Autowired
	private AlunoRepository repository;
	private AlunoModel aluno;

	@Autowired
	private ProfessorRepository prepository;
	private ProfessorModel pmodel;

	List<String> disciplinas = new ArrayList<String>();

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EscolaApplication.class, args);

	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/professores").allowedOrigins("http://localhost:3000");
				registry.addMapping("/alunotodos").allowedOrigins("http://localhost:3000");
			}
		};
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		String strArgs = Arrays.stream(arg0.getSourceArgs()).collect(Collectors.joining("|"));
		log.info("Application started with arguments:" + strArgs);

		log.error(EscolaApplication.class);
		log.info(EscolaApplication.class);

		System.out.println("aplicacao com log habilitado... ");




	}
}
