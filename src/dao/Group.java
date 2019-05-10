package dao;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@NamedQueries({
    @NamedQuery(name = "Group.findByName", query = "Select g From Group g Where g.name LIKE :name")
})

@Entity(name = "Group")
@Table(name = "TGroup")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Basic(optional = false)
	@Column(name = "name", length = 200, nullable = false, unique = true)
	private String name;


	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER, mappedBy = "groupId")
	private Set<Person> persons;
	
//	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
//	@JoinTable(name = "Person_Movie", joinColumns = { @JoinColumn(name = "id_person") }, inverseJoinColumns = {
//			@JoinColumn(name = "id_movie") })
//	Set<Movie> movies;

	@Version()
	private long version = 0;

	@Transient
	public static long updateCounter = 0;

	public Group() {
		super();
	}

	public Group(String firstName) {
		super();
		this.name = firstName;
	}

	@PreUpdate
	public void beforeUpdate() {
		System.err.println("PreUpdate of " + this);
	}

	@PostUpdate
	public void afterUpdate() {
		System.err.println("PostUpdate of " + this);
		updateCounter++;
	}

	@Override
	public String toString() {
		return "Group(id=" + getId() + "," + name + ",v" + getVersion() + ")";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return name;
	}

	public void setFirstName(String firstName) {
		this.name = firstName;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	public void addPerson(Person p) {
		if (persons == null) {
			persons = new HashSet<>();
		}
		persons.add(p);
		p.setGroupId(this);
	}
//
//	public Set<Movie> getMovies() {
//		return movies;
//	}
//
//	public void setMovies(Set<Movie> movies) {
//		this.movies = movies;
//	}
//
//	public void addMovie(Movie movie) {
//		if (movies == null) {
//			movies = new HashSet<>();
//		}
//		movies.add(movie);
//	}

}