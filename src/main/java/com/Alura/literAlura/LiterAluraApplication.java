package com.Alura.literAlura;

import com.Alura.literAlura.principal.Principal;
import com.Alura.literAlura.repositorioBD.RepositorioBD;
import com.Alura.literAlura.repositorioBD.RepositorioBD2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	//Inyectamos nuestra dependencia:
	@Autowired
	private RepositorioBD repository;
	@Autowired
	private RepositorioBD2 repository2;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Principal iniciar = new Principal(repository,repository2);
		iniciar.iniciar();

	}
}
