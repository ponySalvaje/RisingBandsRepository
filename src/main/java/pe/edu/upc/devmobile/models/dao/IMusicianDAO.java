package pe.edu.upc.devmobile.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.devmobile.models.entity.Musician;

@Repository
public interface IMusicianDAO extends JpaRepository<Musician, Long> {
	@Query("select m from Musician m join fetch m.genres g where m.id=?1")
	public Musician fetchByIdWithGenres(Long id);
	
	@Query("select m from Musician m join fetch m.instruments i where m.id=?1")
	public Musician fetchByIdWithInstruments(Long id);
}
