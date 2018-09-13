package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.dao.IMusicianInstrumentDAO;
import pe.edu.upc.devmobile.models.entity.MusicianInstrument;
import pe.edu.upc.devmobile.service.inter.IMusicianInstrumentService;

@Service
public class MusicianInstrumentService implements IMusicianInstrumentService {

	@Autowired
	private IMusicianInstrumentDAO musicianInstrumentDao;
	
	@Override
	public List<MusicianInstrument> findAll() {
		// TODO Auto-generated method stub
		return musicianInstrumentDao.findAll();
	}

	@Override
	public MusicianInstrument findById(Long id) {
		// TODO Auto-generated method stub
		return musicianInstrumentDao.findById(id).orElse(null);
	}

	@Override
	public void save(MusicianInstrument t) {
		// TODO Auto-generated method stub
		musicianInstrumentDao.save(t);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		musicianInstrumentDao.deleteById(id);
	}
}
