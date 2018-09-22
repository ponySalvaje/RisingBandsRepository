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

import pe.edu.upc.devmobile.models.entity.Instrument;
import pe.edu.upc.devmobile.service.impl.InstrumentService;
import pe.edu.upc.devmobile.service.inter.IInstrumentService;

@RestController
@RequestMapping("/api/instrument")
public class InstrumentControllerApi {
	@Autowired
	IInstrumentService instrumentService=new InstrumentService();

	@RequestMapping(value="/list",method = RequestMethod.GET)
	   @ResponseBody
	   public List<Instrument> findAll() {
	       return instrumentService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Instrument findOne(@PathVariable("id") Long id) {
	       return instrumentService.findById( id );
	   }
	 
	   @RequestMapping(value="/",method = RequestMethod.POST)
	   @ResponseStatus(HttpStatus.CREATED)
	   @ResponseBody
	   public void create(@RequestBody Instrument resource) {
	       Preconditions.checkNotNull(resource);
	       instrumentService.save(resource);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	   @ResponseStatus(HttpStatus.OK)
	   public void update(@PathVariable( "id" ) Long id, @RequestBody Instrument resource) {
	       Preconditions.checkNotNull(resource);
	       Instrument foundInstrument =instrumentService.findById( resource.getId());
	       if(foundInstrument!=null)
	       instrumentService.save(foundInstrument);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       instrumentService.deleteById(id);
	   }

}
