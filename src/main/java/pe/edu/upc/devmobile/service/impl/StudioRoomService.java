package pe.edu.upc.devmobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.dao.IStudioRoomDAO;
import pe.edu.upc.devmobile.models.entity.StudioRoom;
import pe.edu.upc.devmobile.service.inter.IStudioRoomService;

@Service
public class StudioRoomService implements IStudioRoomService {

	@Autowired
	private IStudioRoomDAO studioRoomDao;
	
	@Override
	public List<StudioRoom> findAll() {
		// TODO Auto-generated method stub
		return studioRoomDao.findAll();
	}

	@Override
	public StudioRoom findById(Long id) {
		// TODO Auto-generated method stub
		return studioRoomDao.findById(id).orElse(null);
	}

	@Override
	public void save(StudioRoom t) {
		// TODO Auto-generated method stub
		studioRoomDao.save(t);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		studioRoomDao.deleteById(id);
	}

	@Override
	public StudioRoom fetchByIdWithBookings(Long id) {
		// TODO Auto-generated method stub
		return studioRoomDao.fetchByIdWithBookings(id);
	}
}
