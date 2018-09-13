package pe.edu.upc.devmobile.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.devmobile.models.entity.Genre;

@Repository
public interface IGenreDAO extends JpaRepository<Genre, Long> {
	@Query("select g from Genre g where g.name like %?1%")
	public List<Genre> findGenreByName(String term);
}
