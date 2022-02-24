package ada.sebastian.ProyectoRest.repository;

import ada.sebastian.ProyectoRest.domain.UsuarioInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioInfoRepository extends CrudRepository<UsuarioInfo, Integer> {

}
