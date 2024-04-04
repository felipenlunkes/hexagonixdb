package br.lunx.hexagonixdb.hexagonixDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class HexagonixDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexagonixDbApplication.class, args);
	}

}
