package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.dao.IMusicStudioOwnerDAO;
import pe.edu.upc.devmobile.models.entity.MusicStudioOwner;
import pe.edu.upc.devmobile.service.inter.IMusicStudioOwnerService;

@Service
public class MusicStudioOwnerService implements IMusicStudioOwnerService {

	@Autowired
	private IMusicStudioOwnerDAO musicStudioOwnerDao;

	@Override
	public List<MusicStudioOwner> findAll() {
		// TODO Auto-generated method stub
		return musicStudioOwnerDao.findAll();
	}

	@Override
	public MusicStudioOwner findById(Long id) {
		// TODO Auto-generated method stub
		return musicStudioOwnerDao.findById(id).orElse(null);
	}

	@Override
	public void save(MusicStudioOwner t) {
		// TODO Auto-generated method stub
		musicStudioOwnerDao.save(t);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		musicStudioOwnerDao.deleteById(id);
	}
}
