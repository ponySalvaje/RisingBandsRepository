package pe.edu.upc.devmobile.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.devmobile.models.entity.Band;

@Repository
public interface IBandDAO extends JpaRepository<Band, Long> {
	@Query("select b from Band b left join fetch b.events e where b.id=?1")
	public Band fetchByIdWithEvents(Long id);
}
