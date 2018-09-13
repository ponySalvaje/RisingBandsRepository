package pe.edu.upc.devmobile.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import pe.edu.upc.devmobile.models.entity.Band;
import pe.edu.upc.devmobile.models.entity.StudioRoom;

@Entity
@Table(name="Bookings")
public class Booking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date bookDate;
	
	@NotNull
	private Integer startHour;
	
	@NotNull
	private Integer amountHour;
	
	@NotNull
	private Integer endHour;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="studioroom_id")
	private StudioRoom studioRoom;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="band_id")
	private Band band;

	//Access methods
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public Integer getStartHour() {
		return startHour;
	}

	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}

	public Integer getAmountHour() {
		return amountHour;
	}

	public void setAmountHour(Integer amountHour) {
		this.amountHour = amountHour;
	}

	public Integer getEndHour() {
		return endHour;
	}

	public void setEndHour(Integer endhour) {
		this.endHour = endhour;
	}

	public StudioRoom getStudioRoom() {
		return studioRoom;
	}

	public void setStudioRoom(StudioRoom studioRoom) {
		this.studioRoom = studioRoom;
	}

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}
}
