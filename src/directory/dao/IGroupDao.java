package directory.dao;

import java.util.Collection;

import directory.model.*;

public interface IGroupDao extends IDao<Group> {
	Collection<Person> getMembers(long groupId);
	void addMember(long personId);
	void deleteMember(long personId);
	void empty();
}