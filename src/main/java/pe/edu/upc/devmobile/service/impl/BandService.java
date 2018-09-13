package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.Band;
import pe.edu.upc.devmobile.service.inter.IBandService;
import pe.edu.upc.devmobile.models.dao.IBandDAO;

@Service
public class BandService implements IBandService {

	@Autowired
	private IBandDAO bandDao;
	
	@Override
	public List<Band> findAll() {
		// TODO Auto-generated method stub
		return bandDao.findAll();
	}

	@Override
	public Band findById(Long id) {
		// TODO Auto-generated method stub
		return bandDao.findById(id).orElse(null);
	}

	@Override
	public void save(Band t) {
		// TODO Auto-generated method stub
		bandDao.save(t);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		bandDao.deleteById(id);
	}

	@Override
	public Band fetchByIdWithEvents(Long id) {
		// TODO Auto-generated method stub
		return bandDao.fetchByIdWithEvents(id);
	}
}
