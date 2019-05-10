package dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TestDao {

	@Autowired
	IDao dao;
	static Group g1, g2;
	static Person p1, p2, p3;
	
	@Test
	public void testAddFind() {
		g1 = new Group("group1");
		g2 = new Group("group2");
		p1 = new Person("nom1", "prenom1");
		p2 = new Person("nom2", "prenom2");
		p3 = new Person("nom3", "prenom3");
		g1.addPerson(p1);
		g2.addPerson(p2);
		g2.addPerson(p3);
		dao.add(g1);
		dao.add(g2);
		Assert.assertEquals(g1.getId(), dao.find(Group.class, g1.getId()).getId());
		Assert.assertEquals(g2.getId(), dao.find(Group.class, g2.getId()).getId());
		List<Person> persons = new ArrayList<Person>(dao.findAll(Person.class));
		for (Person person : persons) {
			System.err.println(person);
		}
		List<Group> groups = new ArrayList<Group>(dao.findAll(Group.class));
		for (Group group : groups) {
			System.err.println(group);
		}
		groups = new ArrayList<Group>(dao.findByName("group2", Group.class));
		for (Group group : groups) {
			System.err.println(group);
		}
		persons = new ArrayList<Person>(dao.findByName("nom1", Person.class));
		for (Person person : persons) {
			System.err.println(person);
		}
	}
}
