package pe.edu.upc.devmobile.models.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import pe.edu.upc.devmobile.models.entity.Band;
import pe.edu.upc.devmobile.models.entity.Genre;
import pe.edu.upc.devmobile.models.entity.Instrument;

@Entity
@Table(name="Musicians")
public class Musician implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date birthDate;
	
	@NotNull
	private String phoneNumber;
	
	@NotNull
	private String dni;
	
	@NotNull
	@Email
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "musician_id")
	@JsonManagedReference
	private List<Instrument> instruments;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "musician_id")
	@JsonManagedReference
	private List<Genre> genres;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonManagedReference
	private Band band;
	
	//Access methods

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}
	
	public void addInstrument(Instrument instrument) {
		this.instruments.add(instrument);
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	public void addGenre(Genre genre) {
		this.genres.add(genre);
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}
}
