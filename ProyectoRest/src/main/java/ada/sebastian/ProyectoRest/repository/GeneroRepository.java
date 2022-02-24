package ada.sebastian.ProyectoRest.repository;

import ada.sebastian.ProyectoRest.domain.Genero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GeneroRepository extends CrudRepository<Genero, Integer> {

}
