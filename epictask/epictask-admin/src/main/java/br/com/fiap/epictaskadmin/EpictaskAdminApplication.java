package br.com.fiap.epictaskadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class EpictaskAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpictaskAdminApplication.class, args);
	}

}
