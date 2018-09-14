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

import pe.edu.upc.devmobile.models.entity.Musician;
import pe.edu.upc.devmobile.service.impl.MusicianService;
import pe.edu.upc.devmobile.service.inter.IMusicianService;

@RestController
@RequestMapping("/api/musician")
public class MusicianControllerApi {
	@Autowired
	IMusicianService musicianService=new MusicianService();

	@RequestMapping(value="/list",method = RequestMethod.GET)
	   @ResponseBody
	   public List<Musician> findAll() {
	       return musicianService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Musician findOne(@PathVariable("id") Long id) {
	       return musicianService.findById( id );
	   }
	 
	   @RequestMapping(value="/",method = RequestMethod.POST)
	   @ResponseStatus(HttpStatus.CREATED)
	   @ResponseBody
	   public void create(@RequestBody Musician resource) {
	       Preconditions.checkNotNull(resource);
	       musicianService.save(resource);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	   @ResponseStatus(HttpStatus.OK)
	   public void update(@PathVariable( "id" ) Long id, @RequestBody Musician resource) {
	       Preconditions.checkNotNull(resource);
	       Musician foundMusician =musicianService.findById( resource.getId());
	       if(foundMusician!=null)
	       musicianService.save(foundMusician);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       musicianService.deleteById(id);
	   }

}
