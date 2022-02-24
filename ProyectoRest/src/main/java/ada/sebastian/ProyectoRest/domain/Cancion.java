package ada.sebastian.ProyectoRest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cancion")
public class Cancion {
    @Id
    @Column(name = "idcancion", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "artista", length = 45)
    private String artista;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genero_idgenero")
    @JsonIgnore
    private Genero genero;

    @ManyToMany(mappedBy = "cancions")
    @JsonIgnore
    private Set<UsuarioInfo> usuarioInfos = new HashSet<>();

    public Cancion() {
    }

    public Cancion(String nombre) {
        this.nombre = nombre;
    }

    public Cancion(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
    }

    public Cancion(String nombre, String artista, Genero genero) {
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
    }

    public Set<UsuarioInfo> getUsuarioInfos() {
        return usuarioInfos;
    }

    public void setUsuarioInfos(Set<UsuarioInfo> usuarioInfos) {
        this.usuarioInfos = usuarioInfos;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}