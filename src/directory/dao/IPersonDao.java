package directory.dao;

import java.util.Collection;

import directory.model.*;

public interface IPersonDao extends IDao<Person> {
	
	Collection<Person> getAllPersons(long groupId);
	
	Collection<Group> getAllGroups(long personId);
	
	void addToGroup(long groupId); 
}
