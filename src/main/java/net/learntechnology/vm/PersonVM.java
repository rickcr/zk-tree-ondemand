package net.learntechnology.vm;

import net.learntechnology.domain.Person;
import net.learntechnology.tree.PersonRODTreeNodeData;
import net.learntechnology.tree.RODTreeModel;
import net.learntechnology.tree.RODTreeNode;
import net.learntechnology.service.PersonService;
import org.zkoss.bind.annotation.Init;

import java.util.ArrayList;
import java.util.List;

public class PersonVM {

	private PersonService peronsService = new PersonService();

	private RODTreeModel<PersonRODTreeNodeData> personsModel;

	@Init
	public void init() {
		List<Person> people = peronsService.fetchPeople();
		List<RODTreeNode> treeNodes = new ArrayList<RODTreeNode>();
		for (Person emp: people) {
			//I pass in the service class to PersonRODTreeNodeData since I typically use Spring
			//and I find it cleaner on new instances like this to pass in the service, otherwise
			//I'd have to be creating new instances of PersonRODTreeNodeData via Spring with Prototype
			//scope so that I could have the service injected.
			RODTreeNode treeNode = new RODTreeNode(new PersonRODTreeNodeData(emp, peronsService), (List)null );
			treeNodes.add(treeNode);
		}
		RODTreeNode root = new RODTreeNode(null, treeNodes);
		personsModel = new RODTreeModel<PersonRODTreeNodeData>(root);
	}


	public RODTreeModel<PersonRODTreeNodeData> getPersonsModel() {
		return personsModel;
	}
}
