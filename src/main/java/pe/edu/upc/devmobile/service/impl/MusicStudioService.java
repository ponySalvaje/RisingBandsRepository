package pe.edu.upc.devmobile.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.MusicStudio;
import pe.edu.upc.devmobile.models.entity.StudioRoom;
import pe.edu.upc.devmobile.models.repository.MusicStudioRepository;
import pe.edu.upc.devmobile.models.repository.StudioRoomRepository;
import pe.edu.upc.devmobile.service.inter.IMusicStudioService;
@Service
public class MusicStudioService implements IMusicStudioService {
	
	@Autowired
	MusicStudioRepository musicStudioRepository;
	
	@Autowired
	StudioRoomRepository studioRoomRepository;
	
	@Override
	public List<MusicStudio> findAll() {
		return musicStudioRepository.findAll();
	}

	@Override
	public MusicStudio findById(Long id) {
		return musicStudioRepository.findById(id).orElse(null);
	}

	@Override
	public void save(MusicStudio t) {
		musicStudioRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		musicStudioRepository.deleteById(id);
	}

	@Override
	public List<StudioRoom> getStudioRoomsFromMusicStudio(int musicStudioId) {
		List<StudioRoom> studios = studioRoomRepository.findAll();
		List<StudioRoom> studiosFromMusicStudio = new ArrayList<StudioRoom>();
		
		for(int i = 0; i < studios.size(); i++) {
			if (studios.get(i).getMusicStudio().getId() == musicStudioId) {
				studiosFromMusicStudio.add(studios.get(i));
			}
		}
		
		return studiosFromMusicStudio;
	}

}
