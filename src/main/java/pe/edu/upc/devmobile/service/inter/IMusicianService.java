package pe.edu.upc.devmobile.service.inter;

import pe.edu.upc.devmobile.models.entity.Musician;
import pe.edu.upc.devmobile.service.inter.IService;

public interface IMusicianService extends IService<Musician> {
	
	public Musician fetchByIdWithGenres(Long id);
	
	public Musician fetchByIdWithInstruments(Long id);
}