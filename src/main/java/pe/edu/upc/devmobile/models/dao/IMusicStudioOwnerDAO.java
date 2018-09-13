package pe.edu.upc.devmobile.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.devmobile.models.entity.MusicStudioOwner;

@Repository
public interface IMusicStudioOwnerDAO extends JpaRepository<MusicStudioOwner, Long> {
	
}
