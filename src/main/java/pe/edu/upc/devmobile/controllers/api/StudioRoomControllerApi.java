package pe.edu.upc.devmobile.controllers.api;

import java.util.List;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.devmobile.models.entity.StudioRoom;
import pe.edu.upc.devmobile.service.impl.StudioRoomService;
import pe.edu.upc.devmobile.service.inter.IStudioRoomService;

@RestController
@RequestMapping("/api/studioroom")
public class StudioRoomControllerApi {
	@Autowired
	IStudioRoomService studioroomService=new StudioRoomService();

	@RequestMapping(value="/list",method = RequestMethod.GET)
	   @ResponseBody
	   public List<StudioRoom> findAll() {
	       return studioroomService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public StudioRoom findOne(@PathVariable("id") Long id) {
	       return studioroomService.findById( id );
	   }
	 
	   @RequestMapping(value="/",method = RequestMethod.POST)
	   @ResponseStatus(HttpStatus.CREATED)
	   @ResponseBody
	   public void create(@RequestBody StudioRoom resource) {
	       Preconditions.checkNotNull(resource);
	       studioroomService.save(resource);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	   @ResponseStatus(HttpStatus.OK)
	   public void update(@PathVariable( "id" ) Long id, @RequestBody StudioRoom resource) {
	       Preconditions.checkNotNull(resource);
	       StudioRoom foundStudioRoom =studioroomService.findById( resource.getId());
	       if(foundStudioRoom!=null)
	       studioroomService.save(foundStudioRoom);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       studioroomService.deleteById(id);
	   }

}
