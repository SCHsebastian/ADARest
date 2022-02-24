package ada.sebastian.ProyectoRest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario_info")
public class UsuarioInfo {
    @Id
    @Column(name = "acceso_idacceso", nullable = false)
    private Integer id;
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acceso_idacceso")
    @JsonIgnore
    private Acceso acceso;

    @Column(name = "gustos", length = 45)
    private String gustos;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "usuario_has_cancion",
            joinColumns = @JoinColumn(name = "usuario_acceso_idacceso"),
            inverseJoinColumns = @JoinColumn(name = "cancion_idcancion"))
    private Set<Cancion> cancions = new HashSet<>();

    public UsuarioInfo() {
    }

    public UsuarioInfo(String gustos) {
        this.gustos = gustos;
    }

    public UsuarioInfo(Acceso acceso, String gustos) {
        this.acceso = acceso;
        this.gustos = gustos;
    }

    public Set<Cancion> getCancions() {
        return cancions;
    }

    public void setCancions(Set<Cancion> cancions) {
        this.cancions = cancions;
    }

    public String getGustos() {
        return gustos;
    }

    public void setGustos(String gustos) {
        this.gustos = gustos;
    }

    public Acceso getAcceso() {
        return acceso;
    }

    public void setAcceso(Acceso acceso) {
        this.acceso = acceso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}