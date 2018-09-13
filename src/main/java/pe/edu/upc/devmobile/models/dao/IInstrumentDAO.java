package pe.edu.upc.devmobile.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.devmobile.models.entity.Instrument;

@Repository
public interface IInstrumentDAO extends JpaRepository<Instrument, Long>{
	@Query("select i from Instrument i where i.name like %?1%")
	List<Instrument> findInstrumentByName(String term);
}
