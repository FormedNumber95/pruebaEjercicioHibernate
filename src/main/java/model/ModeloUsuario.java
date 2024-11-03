package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class ModeloUsuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usuario_id;
	@Column(length=100, unique = true, nullable = false)
	private String email;
	private int edad;
	@Column(length=100)
	private String nombre;
	@ManyToMany(mappedBy = "usuarios", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<ModeloContenido>contenidos=new HashSet<ModeloContenido>();
	
	public ModeloUsuario(){
	}

	public ModeloUsuario(String email, int edad, String nombre) {
		this.email = email;
		this.edad = edad;
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(usuario_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeloUsuario other = (ModeloUsuario) obj;
		return Objects.equals(usuario_id, other.usuario_id);
	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<ModeloContenido> getContenido() {
		return contenidos;
	}

	public void setContenido(Set<ModeloContenido> contenido) {
		this.contenidos = contenido;
	}
	
	public void aniadirContenido(ModeloContenido contenido) {
		this.contenidos.add(contenido);
	}
	
}
