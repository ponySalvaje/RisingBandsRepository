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

import pe.edu.upc.devmobile.models.entity.Genre;
import pe.edu.upc.devmobile.service.impl.GenreService;
import pe.edu.upc.devmobile.service.inter.IGenreService;

@RestController
@RequestMapping("/api/genre")
public class GenreControllerApi {
	@Autowired
	IGenreService genreService=new GenreService();

	@RequestMapping(value="/list",method = RequestMethod.GET)
	   @ResponseBody
	   public List<Genre> findAll() {
	       return genreService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Genre findOne(@PathVariable("id") Long id) {
	       return genreService.findById( id );
	   }
	 
	   @RequestMapping(value="/",method = RequestMethod.POST)
	   @ResponseStatus(HttpStatus.CREATED)
	   @ResponseBody
	   public void create(@RequestBody Genre resource) {
	       Preconditions.checkNotNull(resource);
	       genreService.save(resource);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	   @ResponseStatus(HttpStatus.OK)
	   public void update(@PathVariable( "id" ) Long id, @RequestBody Genre resource) {
	       Preconditions.checkNotNull(resource);
	       Genre foundGenre =genreService.findById( resource.getId());
	       if(foundGenre!=null)
	       genreService.save(foundGenre);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       genreService.deleteById(id);
	   }

}
