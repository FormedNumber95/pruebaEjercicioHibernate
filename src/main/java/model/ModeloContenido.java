package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class ModeloContenido {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contenido_id;
	@Column(length = 100)
	private String nombre;
	@Column(length = 25)
	private String tag;
	private double tiempo;
	@Column(length = 100)
	private String ubicacion;
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "cuentaCreadora_id")
	private ModeloCuentaCreadora creador;
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "recomendacion",
	joinColumns = @JoinColumn(name = "contenido_id", referencedColumnName = "contenido_id"),
	inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id"))
	private Set<ModeloUsuario>usuarios=new HashSet<ModeloUsuario>();
	
	public ModeloContenido() {
	}

	public ModeloContenido(String nombre, String tag, double tiempo, String ubicacion, ModeloCuentaCreadora creador) {
		this.nombre = nombre;
		this.tag = tag;
		this.tiempo = tiempo;
		this.ubicacion = ubicacion;
		this.creador = creador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contenido_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeloContenido other = (ModeloContenido) obj;
		return Objects.equals(contenido_id, other.contenido_id);
	}

	public Long getContenido_id() {
		return contenido_id;
	}

	public void setContenido_id(Long contenido_id) {
		this.contenido_id = contenido_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public ModeloCuentaCreadora getCreador() {
		return creador;
	}

	public void setCreador(ModeloCuentaCreadora creador) {
		this.creador = creador;
	}

	public Set<ModeloUsuario> getUsuario() {
		return usuarios;
	}

	public void setUsuario(Set<ModeloUsuario> usuario) {
		this.usuarios = usuario;
	}

	public void aniadirUsuario(ModeloUsuario usuario) {
		this.usuarios.add(usuario);
	}
	
}
