package net.learntechnology.service;

import net.learntechnology.domain.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Mock Service in real life this would be a DB related service fetching
//persons and children by parentId, etc
public class PersonService {
	private static Map<Integer, List<Person>> personChildrenMap = new HashMap<Integer,  List<Person>>();

	private static List<Person> people = new ArrayList<Person>();

	static {
		addChildren(1, null, 0);
	}

	private static int addChildren(int currentDepth, Integer personId, int lastId) {
		if (currentDepth <= 3) {
			List<Person> children = personChildrenMap.get(personId);
			for (int i = 1; i <= 10; i++) {
				lastId++;
				Person p = new Person(lastId, "Person-" + lastId);
				if (children != null) {
					children.add(p);
				} else {
					//we're top level
					people.add(p);
				}
				personChildrenMap.put(lastId, new ArrayList<Person>());
				lastId = addChildren(currentDepth + 1, p.getId(), lastId);
			}
		}
		return lastId;
	}

	public int countChildren(Integer id) {
		return personChildrenMap.get(id).size();
	}

	public List<Person> fetchChildren(Integer id) {
		return personChildrenMap.get(id);
	}

	public List<Person> fetchPeople() {
		return people;
	}

	public static void main(String[] args) {

	}
}
