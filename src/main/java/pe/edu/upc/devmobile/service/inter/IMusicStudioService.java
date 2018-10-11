package pe.edu.upc.devmobile.service.inter;

import java.util.List;

import pe.edu.upc.devmobile.models.entity.MusicStudio;
import pe.edu.upc.devmobile.models.entity.StudioRoom;

public interface IMusicStudioService extends IService<MusicStudio>{
	List<StudioRoom> getStudioRoomsFromMusicStudio(int musicStudioId);
}
