package model;

public class Person {
	private String name;
	private String id;
	private Person prevPerson;
	private Person nextPerson;
	
	public Person(String n, String i) {
		name = n;
		id = i;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public Person getPrevPerson() {
		return prevPerson;
	}

	public Person getNextPerson() {
		return nextPerson;
	}

	public void setPrevPerson(Person prevPerson) {
		this.prevPerson = prevPerson;
	}

	public void setNextPerson(Person nextPerson) {
		this.nextPerson = nextPerson;
	}
}
