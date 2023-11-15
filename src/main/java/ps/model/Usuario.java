package ps.model;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;
	 
	 private String nombre;
	 
	 private String apellido;
	 
	 private String correo;
	 
	 private String contraseña;
	 
	 private int celular;
	 
	 private Cuenta id_cuenta;
	 
	 private String rol;
	 
	 private ArrayList<Cuenta>cuentas;
	 
	// Constructor vacío
	public Usuario() {
	}

	public Usuario(long id_usuario, String rol, String nombre, String apellido, String correo, String contraseña, int celular,
			Cuenta id_cuenta) {
		this.rol=rol;
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contraseña = contraseña;
		this.celular = celular;
		this.id_cuenta = id_cuenta;
		this.cuentas= new ArrayList<>();
	}
	public ArrayList<Cuenta> getUsuarios(){
		
		return cuentas;
		
	}

	

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}
	


	public Cuenta getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(Cuenta id_cuenta) {
		this.id_cuenta = id_cuenta;
	}
	
	

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	// Método toString para representar la entidad como cadena
	@Override
	public String toString() {
		return "hola";
		//return "r [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", posicion=" + posicion
		//		+ ", valor=" + valor + "]";
	}
}
