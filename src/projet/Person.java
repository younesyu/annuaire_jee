package projet;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
    @NamedQuery(name = "Person.findByName", query = "Select p From Person p Where p.lastname LIKE :name")
})

@Entity(name = "Person")
@Table(name = "TPerson")
public class Person implements Serializable {

	// default serial UID
	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(length = 150, nullable = false)
	private String lastname;

	@Column(length = 150, nullable = false)
	private String firstname;

	@Column(name = "mail", length = 200, nullable = false)
	String mail;

	@Column(name = "website", length = 200, nullable = false)
	String website;

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_day")
	private Date birthDay;

	@ManyToOne(optional = true)
	@JoinColumn(name = "groupId")
	private Group groupId;

	@Column
	String password;

	public Person() {
		super();
	}

	public Person(String lastname, String firstname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		mail = "mail";
		website = "site";
		birthDay = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Group getGroupId() {
		return groupId;
	}

	public void setGroupId(Group groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "Person(" + id + ":" + lastname + " " + firstname + ")";
	}

}