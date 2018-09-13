package pe.edu.upc.devmobile.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import pe.edu.upc.devmobile.models.entity.Event;
import pe.edu.upc.devmobile.models.entity.Genre;

@Entity
@Table(name="Bands")
public class Band implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	private String socialmedia;
	
	private String musicrepository;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="genre_id")
	@JsonBackReference
	private Genre genre;
	
	@OneToMany(mappedBy="band", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Event> events;
	
	//Access methods

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSocialmedia() {
		return socialmedia;
	}

	public void setSocialmedia(String socialmedia) {
		this.socialmedia = socialmedia;
	}

	public String getMusicrepository() {
		return musicrepository;
	}

	public void setMusicrepository(String musicrepository) {
		this.musicrepository = musicrepository;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	public void addEvents(Event event) {
		this.events.add(event);
	}
}
