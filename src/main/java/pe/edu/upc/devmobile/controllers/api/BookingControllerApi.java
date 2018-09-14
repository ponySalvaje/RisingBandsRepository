package pe.edu.upc.devmobile.controllers.api;

import java.util.List;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.devmobile.models.entity.Booking;
import pe.edu.upc.devmobile.service.impl.BookingService;
import pe.edu.upc.devmobile.service.inter.IBookingService;



@RestController
@RequestMapping("/api/booking")
public class BookingControllerApi {
	@Autowired
	IBookingService bookingService=new BookingService();

	@RequestMapping(value="/list",method = RequestMethod.GET)
	   @ResponseBody
	   public List<Booking> findAll() {
	       return bookingService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Booking findOne(@PathVariable("id") Long id) {
	       return bookingService.findById( id );
	   }
	 
	   @RequestMapping(value="/",method = RequestMethod.POST)
	   @ResponseStatus(HttpStatus.CREATED)
	   @ResponseBody
	   public void create(@RequestBody Booking resource) {
	       Preconditions.checkNotNull(resource);
	       bookingService.save(resource);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	   @ResponseStatus(HttpStatus.OK)
	   public void update(@PathVariable( "id" ) Long id, @RequestBody Booking resource) {
	       Preconditions.checkNotNull(resource);
	       Booking foundBooking =bookingService.findById( resource.getId());
	       if(foundBooking!=null)
	       bookingService.save(foundBooking);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       bookingService.deleteById(id);
	   }

}
