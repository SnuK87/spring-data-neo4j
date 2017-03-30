package de.snuk.neo4j;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Department {

	@GraphId
	private Long id;

	private String name;

	@Relationship(type = "EMPLOYEE", direction = Relationship.INCOMING)
	private Set<Person> employees;

	public Department() {

	}

	public Department(String name) {
		this.name = name;
	}

	public void addEmployee(Person p) {
		if (employees == null) {
			employees = new HashSet<>();
		}

		employees.add(p);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employees=" + employees + "]";
	}
}
