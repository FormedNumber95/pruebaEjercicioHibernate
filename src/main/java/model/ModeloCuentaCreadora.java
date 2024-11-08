package model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CuentaCreadora")
public class ModeloCuentaCreadora {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuentaCreadora_id;
	@Column(length=100, unique = true, nullable = false)
	private String cuenta;
	private int anio;
	@OneToMany(mappedBy="creador")
	private Set<ModeloContenido> contenidos=new HashSet<ModeloContenido>();
	
	public ModeloCuentaCreadora() {
	}
	
	public ModeloCuentaCreadora(String cuenta, int anio) {
		this.cuenta = cuenta;
		this.anio = anio;
	}

	public Long getCuentaCreadora_id() {
		return cuentaCreadora_id;
	}

	public void setCuentaCreadora_id(Long cuentaCreadora_id) {
		this.cuentaCreadora_id = cuentaCreadora_id;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Set<ModeloContenido> getContenido() {
		return contenidos;
	}

	public void setContenidos(Set<ModeloContenido> contenido) {
		this.contenidos = contenido;
	}
	
	public void aniadirContenido(ModeloContenido contenido) {
		this.contenidos.add(contenido);
	}
	
}
