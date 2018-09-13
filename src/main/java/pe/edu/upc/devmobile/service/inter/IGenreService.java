package pe.edu.upc.devmobile.service.inter;

import java.util.List;

import pe.edu.upc.devmobile.models.entity.Genre;

public interface IGenreService extends IService<Genre> {
	
	public List<Genre> findGenreByName(String term);
}
