package pe.edu.upc.devmobile.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import pe.edu.upc.devmobile.models.entity.MusicStudio;

@Entity
@Table(name="StudioRooms")
public class StudioRoom implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Range(min=0, max=200)
	private Float priceHour;

	@ManyToOne(fetch=FetchType.LAZY)
	@JsonManagedReference
	private MusicStudio musicStudio;
	
	@NotNull
	private String daysAvailable;
	
	@OneToMany(mappedBy="studioRoom", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Booking> bookings;
	
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

	public Float getPriceHour() {
		return priceHour;
	}

	public void setPriceHour(Float priceHour) {
		this.priceHour = priceHour;
	}

	public MusicStudio getMusicStudio() {
		return musicStudio;
	}

	public void setMusicStudio(MusicStudio musicStudio) {
		this.musicStudio = musicStudio;
	}

	public String getDaysAvailable() {
		return daysAvailable;
	}

	public void setDaysAvailable(String daysAvailable) {
		this.daysAvailable = daysAvailable;
	}
	
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	public void addBooking(Booking booking) {
		this.bookings.add(booking);
	}
}
