package ps.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Usuario")
public class Usuario {
	private long id_usuario;
	 
	 private String nombre;
	 
	 private String apellido;
	 
	 private String correo;
	 
	 private String contraseña;
	 
	 private int celular;
	 
	 private Cuenta id_cuenta;
	 
	// Constructor vacío
	public Usuario() {
	}

	public Usuario(long id_usuario, String nombre, String apellido, String correo, String contraseña, int celular,
			Cuenta id_cuenta) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contraseña = contraseña;
		this.celular = celular;
		this.id_cuenta = id_cuenta;
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

	public long getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(long id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	// Método toString para representar la entidad como cadena
	@Override
	public String toString() {
		return "hola";
		//return "r [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", posicion=" + posicion
		//		+ ", valor=" + valor + "]";
	}
}
