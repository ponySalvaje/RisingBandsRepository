package pe.edu.upc.devmobile.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.devmobile.models.entity.StudioRoom;

@Repository
public interface IStudioRoomDAO extends JpaRepository<StudioRoom, Long> {
	@Query("select s from StudioRoom s left join fetch s.bookings b where s.id = ?1")
	public StudioRoom fetchByIdWithBookings(Long id);
}
