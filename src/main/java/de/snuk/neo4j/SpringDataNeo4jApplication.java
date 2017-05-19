package de.snuk.neo4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableNeo4jRepositories
public class SpringDataNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataNeo4jApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	CommandLineRunner data(PersonRepository repo, DepartmentRepository departmentRepo, RestTemplate rest) {
		return args -> {
			// repo.deleteAll();
			//
			// Person tester = new Person("Tester");
			// Person kalle = new Person("Kalle");
			// repo.save(tester);
			// repo.save(kalle);
			//
			// tester.worksWith(kalle);
			// repo.save(tester);
			//
			// Iterable<Person> findAll = repo.findAll();
			// findAll.forEach(System.out::println);
			//
			// Department d1 = new Department("Sleeper");
			//
			// d1.addEmployee(kalle);
			// departmentRepo.save(d1);
			//
			// Iterable<Department> findAll2 = departmentRepo.findAll();
			// findAll2.forEach(System.out::println);

			String response = rest.getForObject("http://localhost:8080/test", String.class);
			System.out.println(response);
		};
	}
}
