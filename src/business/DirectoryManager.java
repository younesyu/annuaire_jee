package business;

import java.util.Collection;

import dao.Group;
import dao.Person;

public class DirectoryManager implements IDirectoryManager {

	@Override
	public User newUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findPerson(User user, long personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group findGroup(User user, long groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Person> findAllPersons(User user, long groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(User user, long personId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void savePerson(User user, Person p) {
		// TODO Auto-generated method stub

	}

}
