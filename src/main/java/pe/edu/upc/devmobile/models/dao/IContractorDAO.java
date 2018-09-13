package pe.edu.upc.devmobile.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.devmobile.models.entity.Contractor;

@Repository
public interface IContractorDAO extends JpaRepository<Contractor, Long> {
	@Query("select c from Contractor c left join fetch c.events e where c.id=?1")
	public Contractor fetchByIdWithEvents(Long id);
}
