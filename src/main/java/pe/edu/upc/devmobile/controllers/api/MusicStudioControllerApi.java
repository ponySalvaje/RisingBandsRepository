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

import pe.edu.upc.devmobile.models.entity.MusicStudio;
import pe.edu.upc.devmobile.service.impl.MusicStudioService;
import pe.edu.upc.devmobile.service.inter.IMusicStudioService;

@RestController
@RequestMapping("/api/musicstudio")
public class MusicStudioControllerApi {
	@Autowired
	IMusicStudioService musicstudioService=new MusicStudioService();

	@RequestMapping(value="/list",method = RequestMethod.GET)
	   @ResponseBody
	   public List<MusicStudio> findAll() {
	       return musicstudioService.findAll();
	   }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	   @ResponseBody
	   public MusicStudio findOne(@PathVariable("id") Long id) {
	       return musicstudioService.findById( id );
	   }
	 
	   @RequestMapping(value="/",method = RequestMethod.POST)
	   @ResponseStatus(HttpStatus.CREATED)
	   @ResponseBody
	   public void create(@RequestBody MusicStudio resource) {
	       Preconditions.checkNotNull(resource);
	       musicstudioService.save(resource);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	   @ResponseStatus(HttpStatus.OK)
	   public void update(@PathVariable( "id" ) Long id, @RequestBody MusicStudio resource) {
	       Preconditions.checkNotNull(resource);
	       MusicStudio foundMusicStudio =musicstudioService.findById( resource.getId());
	       if(foundMusicStudio!=null)
	       musicstudioService.save(foundMusicStudio);
	   }
	 
	   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	   @ResponseStatus(HttpStatus.OK)
	   public void delete(@PathVariable("id") Long id) {
	       musicstudioService.deleteById(id);
	   }

}
