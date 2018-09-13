package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.dao.IMusicianDAO;
import pe.edu.upc.devmobile.models.entity.Musician;
import pe.edu.upc.devmobile.service.inter.IMusicianService;

@Service
public class MusicianService implements IMusicianService {

	@Autowired
	private IMusicianDAO musicianDao;
	
	@Override
	public List<Musician> findAll() {
		// TODO Auto-generated method stub
		return musicianDao.findAll();
	}

	@Override
	public Musician findById(Long id) {
		// TODO Auto-generated method stub
		return musicianDao.findById(id).orElse(null);
	}

	@Override
	public void save(Musician t) {
		// TODO Auto-generated method stub
		musicianDao.save(t);
		}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		musicianDao.deleteById(id);
	}

	@Override
	public Musician fetchByIdWithGenres(Long id) {
		// TODO Auto-generated method stub
		return musicianDao.fetchByIdWithGenres(id);
	}

	@Override
	public Musician fetchByIdWithInstruments(Long id) {
		// TODO Auto-generated method stub
		return musicianDao.fetchByIdWithInstruments(id);
	}
}