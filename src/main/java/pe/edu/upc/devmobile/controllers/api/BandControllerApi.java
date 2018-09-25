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

import pe.edu.upc.devmobile.models.entity.Band;
import pe.edu.upc.devmobile.service.impl.BandService;
import pe.edu.upc.devmobile.service.impl.GenreService;
import pe.edu.upc.devmobile.service.inter.IBandService;
import pe.edu.upc.devmobile.service.inter.IGenreService;
@RestController
@RequestMapping("/api/band")
public class BandControllerApi {
	@Autowired
	IBandService bandService=new BandService();
	@Autowired
	IGenreService genreService=new GenreService();

	@RequestMapping(value="/",method = RequestMethod.GET)
	   @ResponseBody
	   public List<Band> findAll() {
	       List<Band> bandas = bandService.findAll();
	    
	       
	       return bandas;
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Band findOne(@PathVariable("id") Long id) {
	       return bandService.findById( id );
	   }
	 
	   @RequestMapping(value="/",method = RequestMethod.POST)
	   @ResponseStatus(HttpStatus.CREATED)
	   @ResponseBody
	   public void create(@RequestBody Band resource) {
	       Preconditions.checkNotNull(resource);
	       bandService.save(resource);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	   @ResponseStatus(HttpStatus.OK)
	   public void update(@PathVariable( "id" ) Long id, @RequestBody Band resource) {
	       Preconditions.checkNotNull(resource);
	       Band foundBand =bandService.findById( resource.getId());
	       if(foundBand!=null)
	       bandService.save(foundBand);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       bandService.deleteById(id);
	   }

}
