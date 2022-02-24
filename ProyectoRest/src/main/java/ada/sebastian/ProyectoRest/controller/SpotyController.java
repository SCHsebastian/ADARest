package ada.sebastian.ProyectoRest.controller;

import ada.sebastian.ProyectoRest.repository.AccesoRepository;
import ada.sebastian.ProyectoRest.repository.CancionRepository;
import ada.sebastian.ProyectoRest.repository.GeneroRepository;
import ada.sebastian.ProyectoRest.repository.UsuarioInfoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpotyController {

    private final AccesoRepository accesoRepository;
    private final CancionRepository cancionRepository;
    private final GeneroRepository generoRepository;
    private final UsuarioInfoRepository usuarioRepository;

    public SpotyController(AccesoRepository accesoRepository, CancionRepository cancionRepository, GeneroRepository generoRepository, UsuarioInfoRepository usuarioRepository) {
        this.accesoRepository = accesoRepository;
        this.cancionRepository = cancionRepository;
        this.generoRepository = generoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/")
    public String showDocumentation(Model model){
        return "index";
    }

    @RequestMapping("/view/usuarios")
    public String getPokemons(Model model) {
        model.addAttribute("pokemons", usuarioRepository.findAll());
        return "usuario/list";
    }

}
