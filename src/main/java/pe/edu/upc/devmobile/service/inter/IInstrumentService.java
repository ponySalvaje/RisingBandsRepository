package pe.edu.upc.devmobile.service.inter;

import java.util.List;

import pe.edu.upc.devmobile.models.entity.Instrument;
import pe.edu.upc.devmobile.service.inter.IService;

public interface IInstrumentService extends IService<Instrument> {
	
	List<Instrument> findInstrumentByName(String term);
}