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

import pe.edu.upc.devmobile.models.entity.Contractor;
import pe.edu.upc.devmobile.service.impl.ContractorService;
import pe.edu.upc.devmobile.service.inter.IContractorService;

@RestController
@RequestMapping("/api/contractor")
public class ContractorControllerApi {
	@Autowired
	IContractorService contractorService=new ContractorService();

	@RequestMapping(value="/list",method = RequestMethod.GET)
	   @ResponseBody
	   public List<Contractor> findAll() {
	       return contractorService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public Contractor findOne(@PathVariable("id") Long id) {
	       return contractorService.findById( id );
	   }
	 
	   @RequestMapping(value="/",method = RequestMethod.POST)
	   @ResponseStatus(HttpStatus.CREATED)
	   @ResponseBody
	   public void create(@RequestBody Contractor resource) {
	       Preconditions.checkNotNull(resource);
	       contractorService.save(resource);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	   @ResponseStatus(HttpStatus.OK)
	   public void update(@PathVariable( "id" ) Long id, @RequestBody Contractor resource) {
	       Preconditions.checkNotNull(resource);
	       Contractor foundContractor =contractorService.findById( resource.getId());
	       if(foundContractor!=null)
	       contractorService.save(foundContractor);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       contractorService.deleteById(id);
	   }
}
