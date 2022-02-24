package ada.sebastian.ProyectoRest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "acceso")
public class Acceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idacceso", nullable = false)
    private Integer id;

    @Column(name = "usuario", length = 45)
    private String usuario;

    @Column(name = "contrasenya", length = 45)
    private String contrasenya;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "acceso")
    @JsonIgnore
    private UsuarioInfo usuarioInfo;

    public Acceso() {
    }

    public Acceso(String usuario, String contrasenya) {
        this.usuario = usuario;
        this.contrasenya = contrasenya;
    }

    public UsuarioInfo getUsuarioInfo() {
        return usuarioInfo;
    }

    public void setUsuarioInfo(UsuarioInfo usuarioInfo) {
        this.usuarioInfo = usuarioInfo;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}