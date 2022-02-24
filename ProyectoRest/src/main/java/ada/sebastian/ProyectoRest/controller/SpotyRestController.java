package ada.sebastian.ProyectoRest.controller;

import ada.sebastian.ProyectoRest.domain.Acceso;
import ada.sebastian.ProyectoRest.domain.Cancion;
import ada.sebastian.ProyectoRest.domain.Genero;
import ada.sebastian.ProyectoRest.domain.UsuarioInfo;
import ada.sebastian.ProyectoRest.repository.AccesoRepository;
import ada.sebastian.ProyectoRest.repository.CancionRepository;
import ada.sebastian.ProyectoRest.repository.GeneroRepository;
import ada.sebastian.ProyectoRest.repository.UsuarioInfoRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@RestController
public class SpotyRestController {

    private final Log log = LogFactory.getLog(this.getClass());

    private final AccesoRepository accesoRepository;
    private final CancionRepository cancionRepository;
    private final GeneroRepository generoRepository;
    private final UsuarioInfoRepository usuarioRepository;

    public SpotyRestController(AccesoRepository accesoRepository, CancionRepository cancionRepository, GeneroRepository generoRepository, UsuarioInfoRepository usuarioRepository) {
        this.accesoRepository = accesoRepository;
        this.cancionRepository = cancionRepository;
        this.generoRepository = generoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // GET

    @GetMapping("/usuarios")//@GetMapping(path = "/usuario", produces = "application/json")
    List<UsuarioInfo> getAll(){
        return (List<UsuarioInfo>) usuarioRepository.findAll();
    }

    @GetMapping("/accesos")
    List<Acceso> getAccesos(){
        return (List<Acceso>) accesoRepository.findAll();
    }

    @GetMapping("/canciones")
    List<Cancion> getCanciones(){
        return (List<Cancion>) cancionRepository.findAll();
    }

    @GetMapping("/generos")
    List<Genero> getGeneros(){
        return (List<Genero>) generoRepository.findAll();
    }

    @GetMapping("/getAcceso/{id}")
    Optional<Acceso> getAcceso(@PathVariable("id") Long id){
        return accesoRepository.findById(Math.toIntExact(id));
    }

    @GetMapping("/getCancion/{id}")
    Optional<Cancion> getCancion(@PathVariable("id") Long id){
        return cancionRepository.findById(Math.toIntExact(id));
    }

    @GetMapping("/getGenero/{id}")
    Optional<Genero> getGenero(@PathVariable("id") Long id){
        return generoRepository.findById(Math.toIntExact(id));
    }

    @GetMapping("/getUsuario/{id}")
    Optional<UsuarioInfo> getUsuario(@PathVariable("id") Long id){
        return usuarioRepository.findById(Math.toIntExact(id));
    }

    //POST

    @PostMapping("/addAcceso")
    void addAcceso(@RequestBody Acceso acceso){
        accesoRepository.save(acceso);
    }

    @PostMapping("/addUsuario")
    void addUsuario(@RequestBody UsuarioInfo usuario){
        usuarioRepository.save(usuario);
    }

    @PostMapping("/addGenero")
    void addGenero(@RequestBody Genero genero){
        generoRepository.save(genero);
    }

    @PostMapping("/addCancion")
    void addCancion(@RequestBody Cancion cancion){
        cancionRepository.save(cancion);
    }

    @PostMapping("/addCanciones")
    void addCanciones(@RequestBody List<Cancion> canciones){
        cancionRepository.saveAll(canciones);
    }

    @PostMapping("/addGeneros")
    void addGeneros(@RequestBody List<Genero> generos){
        generoRepository.saveAll(generos);
    }

    @PostMapping("/addUsuarios")
    void addUsuarios(@RequestBody List<UsuarioInfo> usuarios){
        usuarioRepository.saveAll(usuarios);
    }

    @PostMapping("/addAccesos")
    void addAccesos(@RequestBody List<Acceso> accesos){
        accesoRepository.saveAll(accesos);
    }

    //PUT

    @PutMapping("/updateAcceso/{id}")
    void updateAcceso(@PathVariable("id") Long id, @RequestBody Acceso acceso){
        acceso.setId(Math.toIntExact(id));
        accesoRepository.save(acceso);
    }

    @PutMapping("/updateUsuario/{id}")
    void updateUsuario(@PathVariable("id") Long id, @RequestBody UsuarioInfo usuario){
        usuario.setId(Math.toIntExact(id));
        usuarioRepository.save(usuario);
    }

    @PutMapping("/updateGenero/{id}")
    void updateGenero(@PathVariable("id") Long id, @RequestBody Genero genero){
        genero.setId(Math.toIntExact(id));
        generoRepository.save(genero);
    }

    @PutMapping("/updateCancion/{id}")
    void updateCancion(@PathVariable("id") Long id, @RequestBody Cancion cancion){
        cancion.setId(Math.toIntExact(id));
        cancionRepository.save(cancion);
    }

    //DELETE
    @Transactional
    @DeleteMapping("/deleteAcceso/{id}") //SI NO BORRAS LA RELACION ENTRE USUARIO Y ACCESO, NO BORRAS EL ACCESO
    public void deleteAcceso(@PathVariable("id") Integer id){
        accesoRepository.deleteById(id);
    }

    @Transactional
    @DeleteMapping("/deleteUsuario/{id}")
    void deleteUsuario(@PathVariable("id") Integer id){
        usuarioRepository.deleteById(id);
    }

    @Transactional
    @DeleteMapping("/deleteGenero/{id}")
    void deleteGenero(@PathVariable("id") Integer id){
        generoRepository.deleteById(id);
    }

    @Transactional
    @DeleteMapping("/deleteCancion/{id}")
    void deleteCancion(@PathVariable("id") Integer id){
        cancionRepository.deleteById(id);
    }

    //ESPECIALES
    // SELECT FROM CANCION WHERE CANCION.NOMBRE LIKE '%' + ?1 + '%' AND CANCION.ARTISTA LIKE '%' + ?2 + '%'
    @GetMapping("/getCancion/{nombre}/{artista}")
    Cancion getCanciones(@PathVariable("nombre") String nombre, @PathVariable("artista") String artista){
        return cancionRepository.findByNombreAndArtista(nombre, artista);
    }
    // where canción like
    @GetMapping("/getCancionesLike/{nombre}")
    List<Cancion> getCancionesLike(@PathVariable("nombre") String nombre){
        return cancionRepository.findByNombreLike('%'+nombre+'%');
    }
    @GetMapping("/getCancionesGeneroLike/{nombre}")
    List<Cancion> getCancionesByGenero(String nombre){
        return cancionRepository.findByGenero('%'+nombre+'%');
    }


}
