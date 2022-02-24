package ada.sebastian.ProyectoRest.repository;

import ada.sebastian.ProyectoRest.domain.Cancion;
import ada.sebastian.ProyectoRest.domain.Genero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CancionRepository extends CrudRepository<Cancion, Integer> {
   // GET FROM CANCION WHERE CANCION.NOMBRE = ?1 + '%' AND CANCION.ARTISTA = ?2
    Cancion findByNombreAndArtista(String nombre, String artista);

    List<Cancion> findByNombreLike(String nombre);

    //SELECT cancion.nombre , genero.nombre
    //FROM cancion
    //INNER JOIN genero
    //ON cancion.genero = genero.id WHERE genero.nombre like '%' + ?1 + '%'  ES PUTO IMPOSIBLE ME DOY POR VENCIDO
    @Query(value = "SELECT CANCION.IDCANCION, CANCION.NOMBRE, CANCION.ARTISTA, CANCION.GENERO_IDGENERO FROM CANCION INNER JOIN GENERO ON CANCION.GENERO_IDGENERO=GENERO.IDGENERO WHERE GENERO.NOMBRE=1", nativeQuery = true)
    List<Cancion> findByGenero(String genero);

}
