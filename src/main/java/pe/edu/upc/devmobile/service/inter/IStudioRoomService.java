package pe.edu.upc.devmobile.service.inter;

import java.util.List;

import pe.edu.upc.devmobile.models.entity.Booking;
import pe.edu.upc.devmobile.models.entity.StudioRoom;

public interface IStudioRoomService extends IService<StudioRoom> {
	List<Booking> getBookingsFromStudioRoom(int studioRoomId);
}
