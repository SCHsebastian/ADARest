package ada.sebastian.ProyectoRest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genero")
public class Genero {
    @Id
    @Column(name = "idgenero", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @OneToMany(mappedBy = "genero")
    @JsonIgnore
    private Set<Cancion> cancions = new HashSet<>();

    public Genero() {
    }

    public Genero(String nombre) {
        this.nombre = nombre;
    }

    public Set<Cancion> getCancions() {
        return cancions;
    }

    public void setCancions(Set<Cancion> cancions) {
        this.cancions = cancions;
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