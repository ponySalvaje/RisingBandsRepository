package pe.edu.upc.devmobile.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.devmobile.models.entity.MusicStudio;

@Repository
public interface IMusicStudioDAO extends JpaRepository<MusicStudio, Long> {
	@Query("select m from MusicStudio m left join fetch m.studioRooms s where m.id=?1")
	public MusicStudio fetchByIdWithStudioRooms(Long id);
}
