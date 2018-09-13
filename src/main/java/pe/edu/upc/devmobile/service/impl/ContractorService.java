package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.dao.IContractorDAO;
import pe.edu.upc.devmobile.models.entity.Contractor;
import pe.edu.upc.devmobile.service.inter.IContractorService;

@Service
public class ContractorService implements IContractorService {

	@Autowired
	private IContractorDAO contractorDao;
	
	@Override
	public List<Contractor> findAll() {
		// TODO Auto-generated method stub
		return contractorDao.findAll();
	}

	@Override
	public Contractor findById(Long id) {
		// TODO Auto-generated method stub
		return contractorDao.findById(id).orElse(null);
	}

	@Override
	public void save(Contractor t) {
		// TODO Auto-generated method stub
		contractorDao.save(t);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		contractorDao.deleteById(id);
	}

	@Override
	public Contractor fetchByIdWithEvents(Long id) {
		// TODO Auto-generated method stub
		return contractorDao.fetchByIdWithEvents(id);
	}
}
