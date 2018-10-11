package pe.edu.upc.devmobile.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.devmobile.models.entity.Booking;
import pe.edu.upc.devmobile.models.entity.StudioRoom;
import pe.edu.upc.devmobile.models.repository.BookingRepository;
import pe.edu.upc.devmobile.models.repository.StudioRoomRepository;
import pe.edu.upc.devmobile.service.inter.IStudioRoomService;

@Service
public class StudioRoomService implements IStudioRoomService {

	@Autowired
	private StudioRoomRepository studioRoomRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Override
	public List<StudioRoom> findAll() {
		return studioRoomRepository.findAll();
	}

	@Override
	public StudioRoom findById(Long id) {
		return studioRoomRepository.findById(id).orElse(null);
	}

	@Override
	public void save(StudioRoom t) {
		studioRoomRepository.save(t);
	}

	@Override
	public void deleteById(Long id) {
		studioRoomRepository.deleteById(id);
	}

	@Override
	public List<Booking> getBookingsFromStudioRoom(int studioRoomId) {
		List<Booking> bookings = bookingRepository.findAll();
		List<Booking> bookingsFromStudioRoom = new ArrayList<Booking>();
		
		for(int i = 0; i < bookings.size(); i++) {
			if (bookings.get(i).getStudioRoom().getId() == studioRoomId) {
				bookingsFromStudioRoom.add(bookings.get(i));
			}
		}
		
		return bookingsFromStudioRoom;
	}
}
