package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.dao.IMusicianGenreDAO;
import pe.edu.upc.devmobile.models.entity.MusicianGenre;
import pe.edu.upc.devmobile.service.inter.IMusicianGenreService;

@Service
public class MusicianGenreService implements IMusicianGenreService {

	@Autowired
	private IMusicianGenreDAO musicianGenreDao;
	
	@Override
	public List<MusicianGenre> findAll() {
		// TODO Auto-generated method stub
		return musicianGenreDao.findAll();
	}

	@Override
	public MusicianGenre findById(Long id) {
		// TODO Auto-generated method stub
		return musicianGenreDao.findById(id).orElse(null);
	}

	@Override
	public void save(MusicianGenre t) {
		// TODO Auto-generated method stub
		musicianGenreDao.save(t);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		musicianGenreDao.deleteById(id);
	}

}
