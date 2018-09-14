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
import pe.edu.upc.devmobile.service.inter.IBandService;
@RestController
@RequestMapping("/api/band")
public class BandControllerApi {
	@Autowired
	IBandService bandService=new BandService();

	@RequestMapping(value="/list",method = RequestMethod.GET)
	   @ResponseBody
	   public List<Band> findAll() {
	       return bandService.findAll();
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
