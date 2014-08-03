package net.learntechnology.tree;

import net.learntechnology.domain.Person;
import net.learntechnology.service.PersonService;

import java.util.ArrayList;
import java.util.List;

public class PersonRODTreeNodeData extends RODTreeNodeData {

	private Person person;
	private int count;
	private List<PersonRODTreeNodeData> children;
   	private PersonService personService;

	//I pass in the service class to PersonRODTreeNodeData since I typically use Spring
	//and I find it cleaner on new instances like this to pass in the service, otherwise
	//I'd have to be creating new instances of PersonRODTreeNodeData via Spring with Prototype
	//scope so that I could have the service injected. since this example isn't using Spring
	//you don't have to follow this pattern
	public PersonRODTreeNodeData(Person person, PersonService personService) {
		this.person = person;
		this.personService = personService;
	}

	@Override
	public List<PersonRODTreeNodeData> getChildren() {
		if (children == null) {
			List<Person> personChildren = personService.fetchChildren(person.getId());
			children = new ArrayList<PersonRODTreeNodeData>();
			for (Person emp : personChildren) {
				PersonRODTreeNodeData personRODTreeNodeData = new PersonRODTreeNodeData(emp, this.personService);
				children.add(personRODTreeNodeData);
			}
		}
		return children;
	}

	@Override
	public int getChildCount() {
		count = personService.countChildren(person.getId());
		return count;
	}

	public Person getPerson() {
		return this.person;
	}

	public int getCount() {
		return count;
	}
}
